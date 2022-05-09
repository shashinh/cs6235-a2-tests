class P {
	public static void main(String [] args){
			T1 t1_or_t2;
			O o;
			L lock;
			boolean b;
		try {
			o = new O();
			b = o.getBool();;

			if(b) {
				t1_or_t2 = new T1();
			} else {
				t1_or_t2 = new T2();
			}

			t1_or_t2.start();
			o.qm1();	
			t1_or_t2.join();


		} catch (Exception ex) {
		}
	}
}

class T1 extends Thread {
	L l;

	public void run() {
		T1 t1;
		t1 = this;

		synchronized(l) {
			t1.qm1();
		}
	}

	public void qm1() {}
	public void qm2() {}

}

class T2 extends T1 {
	L l;

	public void run() {
		T2 t2;
		t2 = this;

		synchronized(l) {
			t2.qm1();
		}
	}

	public void qm1() {}
	public void qm2() {}

}

class O {

	public boolean getBool() {
		boolean ret;
		ret = true;
		return ret;
	}
	public void qm1() { }
	public void qm2() { }
	public void qm3() { }
}

class L { }
