//deadlocks with singleton synch objects
class P {
	public static void main(String [] args){
			T1 t1;
			T2 t2;
			L lock1;
			L lock2;
		try {
			lock1 = new L();
			lock2 = new L();

			t1 = new T1();
			t2 = new T2();

			t1.l1 = lock1;
			t1.l2 = lock2;

			t2.l1 = lock2;
			t2.l2 = lock1;

			t1.start();
			t2.start();
		} catch (Exception ex) {
		}
	}
}

class L { }
class T1 extends Thread {
	L l1;
	L l2;

	public void run() {
		T1 t1;
		t1 = this;

		t1.qm3();
		synchronized(l1) {
			t1.qm1();
			synchronized(l2) {
				t1.qm2();
			}
		}
	}

	public void qm1() {}
	public void qm2() {}
	public void qm3() {}

}

class T2 extends Thread {
	L l1;
	L l2;

	public void run() {
		T2 t2;
		t2 = this;

		t2.qm3();
		synchronized(l1) {
			t2.qm1();
			synchronized(l2) {
				t2.qm2();
			}
		}
	}

	public void qm1() {}
	public void qm2() {}
	public void qm3() {}

}

