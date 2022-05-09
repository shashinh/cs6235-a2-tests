class P {
	public static void main(String [] args){
			T1 t1;
			T2 t2;
			boolean b;
		try {

			t1 = new T1();
			t2 = new T2();
			
			t1.start();
			t1.join();

			t2.start();
			t2.join();


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

