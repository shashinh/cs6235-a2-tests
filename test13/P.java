//non-synchronized statements in a thread can run in parallel with synchronized statements
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
		}
	}

	public void qm1() {}
	public void qm2() {}

}

class T2 extends Thread {
	L l;

	public void run() {
		T2 t2;
		t2 = this;

		t2.qm1();
		synchronized(l) {
			t2.qm2();
		}
	}

	public void qm1() {}
	public void qm2() {}

}

class O {
	public void qm1() { }
	public void qm2() { }
	public void qm3() { }
}
