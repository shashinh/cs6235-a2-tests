class P {
	public static void main(String [] args){
			T1 t1;
			O o;
		try {

			o = new O();
			t1 = new T1();

			t1.start();
			t1.join();
			o.qm2();

		} catch (Exception ex) {
		}
	}
}

class T1 extends Thread {
	L lock;

	public void run() {
		T1 t1;
		t1 = this;
		t1.qm1();
	}

	public void qm1() {}

}


class L {
}

class O {
	public void qm2() {}
}
