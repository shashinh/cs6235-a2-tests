//simple synchronization - but on different objects. Statements in synch can run in parallel
class P {
	public static void main(String [] args){
			T1 t1;
			T2 t2;
			O o;
			L lock1;
			L lock2;
			boolean b;
		try {
			t1 = new T1();
			t2 = new T2();
			lock1 = new L();
			lock2 = new L();
			o = new O();

			t1.l = lock1;
			t2.l = lock2;


			t1.start();
			t2.start();

			t1.join();
			t2.join();
			o.qm5();
		} catch (Exception ex) {
		}
	}
}

class L {} 

class T1 extends Thread {
	L l;

	public void run() {
		T1 t1;
		t1 = this;

		synchronized(l) {
			t1.qm();
		}
	}

	public void qm() {}

}

class T2 extends Thread {
	L l;

	public void run() {
		T2 t2;
		t2 = this;

		synchronized(l) {
			t2.qm();
		}
	}

	public void qm() {}

}

class O {
	public void qm1() { }
	public void qm2() { }
	public void qm3() { }
	public void qm4() { }
	public void qm5() { }
}
