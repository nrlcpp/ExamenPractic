package Domain;

    public class Car extends Entity {

        private String model;
        private String id;
        private int kilometrajAchizitie;
        private double price;

        public Car(String model, String id, int kilometrajAchizitie) {
            this.model = model;
            this.id = id;
            this.kilometrajAchizitie = kilometrajAchizitie;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "model='" + model + '\'' +
                    ", kilometrajAchizitie=" + kilometrajAchizitie +
                    ", price=" + price +
                    '}';
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getKilometrajAchizitie() {
            return kilometrajAchizitie;
        }

        public void setKilometrajAchizitie(int kilometrajAchizitie) {
            this.kilometrajAchizitie = kilometrajAchizitie;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double CurrentKm() {
            int coverdKm = 0;
            return kilometrajAchizitie + coverdKm;
        }
    }

