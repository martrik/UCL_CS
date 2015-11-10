import processing.serial.*;
Serial myPort;

int boardState = 0;
int light = 0;
float scaledLight = 0;
float temp = 0;
float scaledTemp = 0;
int heading;
int buttonState = 0;
float[] accel = {0,0,0};
float[] scaledAccel = {0,0,0};


void setup() {
  size(800, 700);

  myPort = new Serial(this,Serial.list()[1],9600);
  myPort.bufferUntil('\n'); 
}

void serialEvent(Serial myPort) {
  String inString = myPort.readStringUntil('\n');
  if(inString != null) {
    inString = trim(inString);
    float[] vals = float(split(inString,","));
    
    if (vals.length == 7) { // Other prints will be ignored
      light = (int)vals[0];
      scaledLight = map(vals[0],0,400,0,150);
      temp = vals[1];
      scaledTemp = map(vals[1],0,40,0,150);
      heading = (int)vals[2];
      buttonState = (int)vals[3];
      accel[0] = round(vals[4]*100)/10.0;
      accel[1] = round(vals[5]*100)/10.0;
      accel[2] = round(vals[6]*100)/10.0;
      scaledAccel[0] = map(vals[4],-1,1,-50,50);
      scaledAccel[1] = map(vals[5],-1,1,-50,50);
      scaledAccel[2] = map(vals[6],-1,1,-50,50);
      boardState = 2;
    } else boardState = 1;
  } else boardState = 0; 
}

void draw() {
  noStroke();
  background(0);
  textAlign(CENTER);

  if (boardState == 2) {
    drawLightGraph();
    drawTemperatureGraph();
    drawAccelerometerGraph();
    drawCompass();
    drawButtonState();
  } 
  else if (boardState == 1) {
    textSize(25);
    text("The board isn't printing the expected amount of values.\nRead the documentation.", width/2, height/2);
  }
  else {
    textSize(25);
    text("The board isn't printing any value.\nRead the documentation.", width/2, height/2);
  } 
}

void drawLightGraph() {
  fill(255);
  textSize(25);
  text("Light", 250, 100);
  
  textSize(20);
  text(light, 250, 330-scaledLight);
  
  fill(255, 200, 0);
  rect(200, 350, 100, -scaledLight);
}

void drawTemperatureGraph() {
  fill(255);
  textSize(25);
  text("Temperature", 550, 100);
  
  textSize(20);
  text(temp, 550, 330-scaledTemp);
  
  fill(0, 255, 0);
  rect(500, 350, 100, -scaledTemp);
}

void drawAccelerometerGraph() {
  fill(255);
  textSize(25);
  text("Accelerometer", 150, 420);
  
  fill(0, 0, 255);
  rect(150, 470, scaledAccel[0], 50);
  rect(150, 520, scaledAccel[1], 50);
  rect(150, 570, scaledAccel[2], 50);
  
  fill(255);
  textSize(18);
  text("X:" + accel[0], 100+scaledAccel[0], 500);
  text("Y:" + accel[1], 100+scaledAccel[1], 550);
  text("Z:" + accel[2], 100+scaledAccel[2], 600);  
}

void drawCompass() {
  fill(255);
  textSize(25);
  text("Compass", 400, 420);
  
  pushMatrix();
  translate(400,550);
  
  stroke(255);
  strokeWeight(5);
  line(0,0,0,-90);
  
  rotate(radians(heading));
    
  for (int deg = 6; deg < 366; deg += 6) {
    float radians = radians(deg);
    float x = cos(radians)* 80;
    float y = sin(radians)* 80;
    
    if (deg%5==0 && deg%2==0 && (deg/10)%3==0) {
      stroke(0,255,36);
      strokeWeight(3);
    }
    else {
      stroke(255);
      strokeWeight(1);
    }
    line(0,0, x,y);
  }
  
  fill(0); 
  noStroke();
  ellipseMode(CENTER);
  ellipse(0,0, 130,130);
   
  fill(255);
  textSize(20);
  text("N", 0, -90);
  rotate(radians(90));
  text("E", 0, -90);
  rotate(radians(90));
  text("S", 0, -90);
  rotate(radians(90));
  text("W", 0, -90);
  rotate(radians(90));
  
  popMatrix();
  
  textSize(25);
  fill(255);
  text(heading+"º", 400,550);
}

void drawButtonState() {
  fill(255);
  textSize(25);
  text("Button", 650, 420);
  
  if (buttonState == 1) {
    fill(0, 255, 0);
    rect(610, 450, 100, 60);
    fill(255);
    text("ON", 660, 485);
  } else {
    fill(255, 0, 0);
    rect(610, 510, 100, 60);
    fill(255);
    text("OFF", 660, 550);
  }  
}