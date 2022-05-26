//nodes should not be killed when a non-singleton thread object is joined
class P {
	public static void main(String [] args){
			T1 t1;
			T1 t2;
			O o;
			boolean b;
		try {
			o = new O();
			b = o.getBool();;

			if(b) {
				t1 = new T1();
				t2 = new T2();
			} else {
				t1 = new T2();
				t2 = new T1();
			}
			
			o.qm1();
			t1.start();
			t2.start();
			t1.join();
			o.qm2();
			t2.join();

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
	public void qm2() { }
}

