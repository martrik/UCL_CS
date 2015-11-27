// Martí Serra 2015
// Engduino code that prints all the sensors' values
// to the serial port

#include <EngduinoButton.h>
#include <EngduinoThermistor.h>
#include <EngduinoAccelerometer.h>
#include <EngduinoMagnetometer.h>
#include <Wire.h>
#include <EngduinoLight.h>


void setup() {
  Serial.begin(9600);
  EngduinoLight.begin();
  EngduinoAccelerometer.begin();
  EngduinoMagnetometer.begin();
  EngduinoThermistor.begin();
  EngduinoButton.begin();
}

void loop() {  
  float accel[3];
  EngduinoAccelerometer.xyz(accel);
  float accelX = accel[0];
  float accelY = accel[1];
  float accelZ = accel[2];

  float magneField[3];
  EngduinoMagnetometer.xyz(magneField);
  float magneX = magneField[0];
  float magneY = magneField[1];

  // Calibrate magnetometer
  magneX = map(magneX, -100, 450, -180, 180);
  magneY = map(magneY, 250, 700, -180, 180);
  
  float Pi = 3.14159;
  float heading = (atan2(magneY,-magneX) * 180) / Pi;  
  
  if (heading < 0) heading += 360;
  if (heading > 360) heading -= 360;
  
  Serial.print(EngduinoLight.lightLevel());
  Serial.print(",");
  Serial.print(EngduinoThermistor.temperature(CELSIUS));
  Serial.print(",");
  Serial.print(heading);
  Serial.print(",");
  Serial.print(EngduinoButton.isPressed());
  Serial.print(",");
  Serial.print(accelX);
  Serial.print(",");
  Serial.print(accelY);
  Serial.print(",");
  Serial.println(accelZ);
  
  delay(100);
}
