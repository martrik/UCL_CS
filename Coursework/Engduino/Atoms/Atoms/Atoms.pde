import processing.serial.*;
Serial myPort;

int boardState = 0;
int light = 0;
float temp = 0;
int heading;
int buttonState = 0;
float[] accel = {0,0,0};

float[] xPositions = new float[500];
float[] yPositions = new float[500];
float[] zPositions = new float[500];

void setup() {
  size(800, 700, P3D);
  smooth();
  
  myPort = new Serial(this,Serial.list()[1],9600);
  myPort.bufferUntil('\n');
  
  createInitialPositionArrays();
}

void draw() {
  background(9, 41, 171);
  lights();
  textAlign(CENTER); 

  if (boardState == 2) {
    camera(cos(radians(heading))*width/2 + width/2, height/2, sin(radians(heading))*(height/2)/tan(PI/8), width/2, height/2 + height/2*accel[0], 0, 0, 1, 0);
    drawPoints();
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

void drawPoints() {
  for (int i = 0; i<xPositions.length; i++) {
    pushMatrix();
    translate(random(-2,2)+xPositions[i], random(-2,2)+yPositions[i], random(-2,2)+zPositions[i]);
    fill(255);
    noStroke();
    sphere(2);
    popMatrix();
  }    
}

void createInitialPositionArrays() {
  for (int i = 0; i<xPositions.length; i++) {    
    xPositions[i] = random(-100, width+100);
    yPositions[i] = random(-100, height+100);
    zPositions[i] = random(-300, 300);
  }
}

void serialEvent(Serial myPort) {
  String inString = myPort.readStringUntil('\n');
  if(inString != null) {
    inString = trim(inString);
    float[] vals = float(split(inString,","));
    
    if (vals.length == 7) { // Other prints will be ignored
      light = (int)map(vals[0],0,400,0,100);
      temp = map(vals[1],0,40,0,100);
      if (abs(heading-vals[2])>1.5 && abs(vals[4])< 0.3) heading = (int)vals[2];
      accel[0] = vals[4];
      boardState = 2;
    } else boardState = 1;
  } else boardState = 0; 
}