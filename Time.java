class Time {
    int hr, min, sec;

    // Constructor
    Time(int hr, int min, int sec) {
        this.hr = hr;
        this.min = min;
        this.sec = sec;
    }

    // Method to add two time objects
    void addTime(Time t1, Time t2) {
        // 1. Add seconds and handle carry (60s = 1min)
        this.sec = t1.sec + t2.sec;
        int carryMin = this.sec / 60;
        this.sec %= 60;

        // 2. Add minutes and handle carry (60min = 1hr)
        this.min = t1.min + t2.min + carryMin;
        int carryHr = this.min / 60;
        this.min %= 60;

        // 3. Add hours
        this.hr = t1.hr + t2.hr + carryHr;

        System.out.println("Total Time: " + this.hr + "h " + this.min + "m " + this.sec + "s");
    }

    // The missing piece: The Main Method
    public static void main(String[] args) {
        // Time 1: 2h 45m 50s
        Time t1 = new Time(2, 45, 50);
        
        // Time 2: 1h 20m 20s
        Time t2 = new Time(1, 20, 20);
        
        // Empty object to store the result
        Time result = new Time(0, 0, 0);
        result.addTime(t1, t2);
    }
}