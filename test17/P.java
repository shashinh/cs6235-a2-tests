//thread object is non-singleton, statically either thread may be executed
class P {
	public static void main(String [] args){
			T1 t1_or_t2;
			O o;
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

	public void run() {
		T1 t1;
		t1 = this;

		t1.qm1();
	}

	public void qm1() {}

}

class T2 extends T1 {

	public void run() {
		T2 t2;
		t2 = this;

		t2.qm1();
	}

	public void qm1() {}

}

class O {

	public boolean getBool() {
		boolean ret;
		ret = true;
		return ret;
	}
	public void qm1() { }
}

