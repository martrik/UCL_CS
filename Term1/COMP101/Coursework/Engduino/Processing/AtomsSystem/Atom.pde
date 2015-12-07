class Atom {
  PVector location;
  PVector velocity;
  
  int counter = 0;  

  Atom(PVector l) {
    location = l.copy();
    velocity = new PVector(0,0);
  }

  void run() {
    update();
    display();    
  }

  void update() {
    location.add(velocity);
    velocity = new PVector(random(-temp,temp),random(-temp,temp)); // Atoms move more if temp is higher
  }

  void display() {
    pushMatrix();
    translate(location.x,location.y,location.z);
    fill(255);
    noStroke();
    sphere(3);
    popMatrix();
  }
}