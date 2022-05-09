class P {
	public static void main(String [] args){
			T1 t1;
			T2 t2;
			O o;
			boolean b;
		try {

			o = new O();
			t1 = new T1();
			t2 = new T2();
			
			t1.start();
			o.qm1();
			t2.start();
			o.qm2();
			t2.join();
			o.qm3();
			t1.join();


		} catch (Exception ex) {
		}
	}
}

class T1 extends Thread {

	public void run() {
		T1 t1;
		t1 = this;
		t1.qm();
	}

	public void qm() {}

}

class T2 extends Thread {

	public void run() {
		T2 t2;
		t2 = this;
		t2.qm();
	}

	public void qm() {}

}

class O {
	public void qm1() { }
	public void qm2() { }
	public void qm3() { }
}
