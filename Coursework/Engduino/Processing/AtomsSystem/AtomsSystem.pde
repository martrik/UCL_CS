// Martí Serra 2015
// 3D environment that recreates gas atoms behaviour

import processing.serial.*;
Serial myPort;

int boardState = 0;
float light = 0;
float temp = 0;
float heading = 0;
int buttonState = 0;
PVector accel = new PVector(0,0,0);

final int n = 500;
ArrayList<Atom> atoms = new ArrayList<Atom>(n);

boolean atomsLoaded = false;

void setup() {
  size(800, 700, P3D);
  smooth();
  
  myPort = new Serial(this,Serial.list()[1],9600); // Substitute the "1" for your Engduino port
  myPort.bufferUntil('\n');
}

void draw() {
  lights();
  textAlign(CENTER); 
  if (light>1) light = 1;
  background(0,100*light,255*light);

  if (boardState == 2) {
    // Adjust camera y rotation with compass heading and x with accelerometer
    camera(cos(radians(heading))*width/2 + width/2, height/2, sin(radians(heading))*(height/2)/tan(PI/8), width/2, height/2 + height/2*accel.x, 0, 0, 1, 0);
    
    if (!atomsLoaded) {
      atomsLoaded = true;
      initAtoms();
    }
    
    run();
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

void initAtoms() {
    for (int i = n-1; i >= 0; i--) {
      // Init atom with random position
      atoms.add(new Atom(new PVector(random(-100, width+100), random(-100, width+100),random(-300,300))));
    }
}

void run() {
  for (int i = atoms.size()-1; i >= 0; i--) {
     Atom a = atoms.get(i);
     a.run();
   }
}

void serialEvent(Serial myPort) {
  String inString = myPort.readStringUntil('\n');
  
  if(inString != null) {
    inString = trim(inString);
    float[] vals = float(split(inString,","));
    
    if (vals.length == 7) { // Other prints will be ignored
      light = map(vals[0],0,150,0,1);
      temp = map(vals[1],-273,40,0,10);
      buttonState = (int)vals[3];
      if (buttonState == 1) accel.x = vals[4];
      else heading = vals[2];
      boardState = 2;
    } 
    else boardState = 1;
  } 
  else boardState = 0; 
}