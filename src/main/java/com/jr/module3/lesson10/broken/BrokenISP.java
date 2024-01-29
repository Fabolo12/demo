package com.jr.module3.lesson10.broken;

public class BrokenISP {
    interface Calc {
        void sum();

        void sub();

        void mult();

        void div();
    }

    class CalcExternalImpl implements Calc {
        public void sum() {

        }

        public void sub() {

        }

        public void mult() {
            throw new UnsupportedOperationException();
        }

        public void div() {
            throw new UnsupportedOperationException();
        }
    }

    class CalcInternalImpl implements Calc {
        public void sum() {

        }

        public void sub() {

        }

        public void mult() {

        }

        public void div() {

        }
    }
}
