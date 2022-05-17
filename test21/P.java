//synch object is non-singleton - variation
class P {
	public static void main(String [] args){
			T1 t1;
			T2 t2;
			O o;
			L lock1;
			L lock2;
			L x;
			L y;
			L z;
			boolean b1;
			boolean b2;
		try {
			o = new O();
			t1 = new T1();
			t2 = new T2();
			x = new L();
			y = new L();
			z = new L();

			b1 = o.getBool();;
			b2 = o.getBool();;

			if(b1) {
				lock1 = x;
			} else {
				lock1 = y;
			}

			if(b2) {
				lock2 = y;
			} else {
				lock2 = z;
			}

			t1.l = lock1;
			t2.l = lock2;

			o.qm();
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
	public void qm() { }
	public boolean getBool() {
		boolean ret;
		ret = true;
		return ret;
		
	}
}
