class Distance {
    int m, cm, mm;

    // Constructor to initialize the values
    Distance(int m, int cm, int mm) {
        this.m = m;
        this.cm = cm;
        this.mm = mm;
    }

    // Method to add two distance objects
    void addDistance(Distance d1, Distance d2) {
        // Adding millimeters
        this.mm = d1.mm + d2.mm;
        int carryCm = this.mm / 10;
        this.mm %= 10;

        // Adding centimeters + carry from mm
        this.cm = d1.cm + d2.cm + carryCm;
        int carryM = this.cm / 100;
        this.cm %= 100;

        // Adding meters + carry from cm
        this.m = d1.m + d2.m + carryM;

        System.out.println("Total Distance: " + this.m + "m " + this.cm + "cm " + this.mm + "mm");
    }

    // This is the part the error was looking for!
    public static void main(String[] args) {
        // Input values for distance 1
        Distance d1 = new Distance(5, 80, 7);
        
        // Input values for distance 2
        Distance d2 = new Distance(2, 40, 5);
        
        // Result object to perform the addition
        Distance result = new Distance(0, 0, 0);
        result.addDistance(d1, d2);
    }
}