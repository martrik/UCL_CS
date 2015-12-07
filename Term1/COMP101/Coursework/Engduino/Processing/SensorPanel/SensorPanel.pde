// Martí Serra 2015
// Simplistic representation in graphs of the Engduino sensors' data

import processing.serial.*;
Serial myPort;

int boardState = 0;
int light = 0;
float scaledLight = 0;
float temp = 0;
float scaledTemp = 0;
int heading;
int buttonState = 0;
PVector accel = new PVector(0,0,0);
PVector scaledAccel = new PVector(0,0,0);

void setup() {
  size(800, 700);

  // Start reading from serial port
  myPort = new Serial(this,Serial.list()[1],9600); // Substitute the "1" for your Engduino port
  myPort.bufferUntil('\n'); 
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
    text("The board isn't printing the expected amount of values.\nRead the documentation for help.", width/2, height/2);
  }
  else {
    textSize(25);
    text("The board isn't printing any value.\nRead the documentation for help.", width/2, height/2);
  } 
}

void drawLightGraph() {
  fill(255);
  textSize(25);
  text("Light", 250, 80);
  
  textSize(20);
  text(light, 250, 310-scaledLight);
  
  fill(255, 200, 0);
  rect(200, 330, 100, -scaledLight);
}

void drawTemperatureGraph() {
  fill(255);
  textSize(25);
  text("Temperature", 550, 80);
  
  textSize(20);
  text(temp+"ºC", 550, 310-scaledTemp);
  
  fill(0, 255, 0);
  rect(500, 330, 100, -scaledTemp);
}

void drawAccelerometerGraph() {
  fill(255);
  textSize(25);
  text("Accelerometer", 150, 420);
  
  fill(0, 0, 255);
  rect(150, 470, scaledAccel.x, 50);
  rect(150, 520, scaledAccel.y, 50);
  rect(150, 570, scaledAccel.z, 50);
  
  fill(255);
  textSize(18);
  text("X:" + accel.x, 100+scaledAccel.x, 500);
  text("Y:" + accel.y, 100+scaledAccel.y, 550);
  text("Z:" + accel.z, 100+scaledAccel.z, 600);  
}

void drawCompass() {
  fill(255);
  textSize(25);
  text("Compass", 400, 420);
  
  pushMatrix();
  translate(400,550); // Move coordinate system to the compass centre
  
  stroke(255);
  strokeWeight(5);
  line(0,0,0,-90);
  
  rotate(radians(heading));
    
  for (int deg = 6; deg < 366; deg += 6) {
    float radians = radians(deg);
    float x = cos(radians)* 80;
    float y = sin(radians)* 80;
    
    // Highlight some compass lines 
    if (deg%30==0) {
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
  rotate(HALF_PI);
  text("E", 0, -90);
  rotate(HALF_PI);
  text("S", 0, -90);
  rotate(HALF_PI);
  text("W", 0, -90);
  rotate(HALF_PI);
  
  popMatrix(); // Reset previous properties
  
  textSize(25);
  fill(255);
  text(heading+"º", 403,555);
}

void drawButtonState() {
  fill(255);
  textSize(25);
  text("Button", 660, 420);
  
  if (buttonState == 1) {
    fill(0, 255, 0);
    rect(580, 470, 80, 50);
    fill(255);
    text("ON", 620, 500);
  } else {
    fill(255, 0, 0);
    rect(660, 470, 80, 50);
    fill(255);
    text("OFF", 700, 500);
  }  
}

void serialEvent(Serial myPort) {
  String inString = myPort.readStringUntil('\n');
  if(inString != null) {
    inString = trim(inString);
    float[] vals = float(split(inString,","));
    
    if (vals.length == 7) { // Other prints will be ignored
      light = (int)vals[0];
      scaledLight = map(vals[0],0,400,0,150);
      temp = round(vals[1]*100)/100.0;
      scaledTemp = map(vals[1],0,40,0,150);
      heading = (int)vals[2];
      buttonState = (int)vals[3];
      accel = new PVector(round(vals[4]*100)/10.0, round(vals[5]*100)/10.0, round(vals[6]*100)/10.0);
      scaledAccel = new PVector(map(vals[4],-1,1,-50,50), map(vals[5],-1,1,-50,50), map(vals[6],-1,1,-50,50));
      boardState = 2;
    } else boardState = 1;
  } else boardState = 0; 
}