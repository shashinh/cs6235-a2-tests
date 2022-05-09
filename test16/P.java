class P {
	public static void main(String [] args){
			T1 t1;
			T2 t2;
			O o;
			L lock;
		try {
			t1 = new T1();
			t2 = new T2();
			lock = new L();

			t1.l = lock;
			t2.l = lock;

			t1.start();
			t2.start();

			t1.join();
			t2.join();
		} catch (Exception ex) {
		}
	}
}

class T1 extends Thread {
	L l;

	public void run() {
		T1 t1;
		t1 = this;

		t1.qm1();
		synchronized(l) {
			t1.qm2();
			l.notifyAll();
			t1.qm3();
		}
		t1.qm4();
	}

	public void qm1() {}
	public void qm2() {}
	public void qm3() {}
	public void qm4() {}

}

class T2 extends Thread {
	L l;

	public void run() {
		T2 t2;
		t2 = this;

		t2.qm1();
		synchronized(l) {
			t2.qm2();
			l.wait();
			t2.qm3();
		}
		t2.qm4();
	}

	public void qm1() {}
	public void qm2() {}
	public void qm3() {}
	public void qm4() {}

}

class O {
	public void qm1() { }
	public void qm2() { }
	public void qm3() { }
}
