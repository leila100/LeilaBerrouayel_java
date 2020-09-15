public class Machine {
    String id;
    String name;
    int units;
    int adds;
    float temperature;
  
    public Machine(String name, String id) {
      super();
      this.id = id;
      this.name = name;
      this.units = 0;
      this.adds = 0;
      this.temperature = 0;
    }
  
    public void add(int addValue) {
      this.units += addValue;
      this.adds += 1;
    }

    public void temperature(float tempVal) {
        this.temperature = tempVal;
    }

    public void temperature() {
        System.out.println(this.temperature);
    }


    public void total() {
        System.out.println(this.units);
    }

    public void average() {
        System.out.println(this.units / this.adds);
    }
}