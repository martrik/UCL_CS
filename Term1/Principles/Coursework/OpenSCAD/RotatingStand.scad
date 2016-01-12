// Martí Serra 2015
// This a 3D model of a Engduino rotating stand

RESOLUTION  = 30;

BASE_WIDTH  = 80;
BASE_LENGTH = 170;
BASE_HEIGHT = 12;
LEGS_LENGTH = 55;
COLU_HEIGHT = 65;
COLU_LENGTH = 25;
BAR_RADIUS  = 9;
BAR_LENGTH  = 50;
USB         = [12,15,4.5];
PLAIN       = [13,12,1.5]; 

module base(length = BASE_LENGTH, width = BASE_WIDTH, height = BASE_HEIGHT, legs = LEGS_LENGTH) {
    
    // Base left side
    translate([-width/2, -length/2, 0]) {
        cube([width, height, height]);
        cube([height,legs,height]);
        translate([0,legs,0]) {
            cube([width/2-height/2, height, height]);
            translate([width/2-height/2, 0, 0])
                cube([height, length-2*legs, height]);
        }
    }
    
    // Base right side
    translate([-width/2, length/2-height, 0]) {
        cube([width, height, height]);
        translate([width-height,-legs,0]) {
            cube([height,legs,height]);
            translate([-width/2+height/2,0,0])
                cube([width/2, height, height]);
        }
    }
}

module columns(height = COLU_HEIGHT, length = COLU_LENGTH, width = BASE_HEIGHT, radius = BAR_RADIUS, base = BASE_LENGTH) {
    
    // Left column
    translate([-length/2, -base/2, width]) {
        difference() {
            cube([length,width,height]);
            bar(width+10, radius, length/2,width+5,height-radius*2);
        }
        
        // USB bar
        translate([length/2,height-25,height-radius*2]) {
            difference() {
                bar(BAR_LENGTH, radius, 0, 0,0);
                translate([-USB[0]/2-2.5,-USB[1],-USB[2]/2])
                    rotate([0,0,-12])
                    cube([USB[0], USB[1] +4, USB[2]]);
            }
        }
    }
    
    // Right column
    translate([-length/2, base/2-width, width]) {
        difference() {
            cube([length,width,height]);
            bar(width+10, radius, length/2,width+5,height-radius*2);
        }
        
        // Plains bar
        translate([length/2,width+10,height-radius*2]) {
            bar(BAR_LENGTH, radius, 0,0,0);
            // Lower pain
            translate([-PLAIN[0]/2,-BAR_LENGTH-PLAIN[1],-1-PLAIN[2]]) {
                difference() {
                    cube([PLAIN[0],PLAIN[1],PLAIN[2]]);
                    translate([PLAIN[0]/2, PLAIN[1]/2, -3])
                        cylinder(h = 10, r = 1.5, $fn=RESOLUTION);
                }
            }
            // Upper plain
            translate([-PLAIN[0]/2,-BAR_LENGTH-PLAIN[1],+1]) {
                difference(){
                    cube([PLAIN[0],PLAIN[1],PLAIN[2]]);
                    translate([PLAIN[0]/2, PLAIN[1]/2, -3])
                    cylinder(h = 20, r = 1.5, $fn=RESOLUTION);
               }
               // Cylinder block
               translate([-10,5,-7])
               cylinder(h = 15, r = 1.5, $fn=RESOLUTION);
           }
           
        }
    }
}

module bar(length, radius, x, y, z) {
    translate([x,y,z]) 
        rotate([90,0,0])
            cylinder(h = length, r = radius, $fn=RESOLUTION);   
}

base();
columns();
