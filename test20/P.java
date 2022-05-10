//synch object is non-singleton
class P {
	public static void main(String [] args){
			T1 t1;
			T2 t2;
			O o;
			L lock;
			L x;
			L y;
			boolean b;
		try {
			o = new O();
			t1 = new T1();
			t2 = new T2();
			x = new L();
			y = new L();

			b = o.getBool();;

			if(b) {
				lock = x;
			} else {
				lock = y;
			}

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

class L { }
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
	public boolean getBool() {
		boolean ret;
		ret = true;
		return ret;
	}
}
