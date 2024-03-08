package org.example;

    public class Buyer {
        private int buyerId;
        private String name;
        private String email;
        private String phone;

        public Buyer() {
        }

        public Buyer(String name, String email, String phone) {
            this.name = name;
            this.email = email;
            this.phone = phone;
        }

        public Buyer(int id, String name, String email) {
        }

        public int getBuyerId() {
            return buyerId;
        }

        public void setBuyerId(int buyerId) {
            this.buyerId = buyerId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }


    }

