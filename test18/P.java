//a thread can run in parallel with its grandfather
class P {
	public static void main(String [] args){
			T1 t1;
			O o;
			L lock;
		try {
			o = new O();
			t1 = new T1();

			t1.start();
			o.qm1();
			t1.join();
			o.qm2();
		} catch (Exception ex) {
		}
	}
}

class L { }

class T1 extends Thread {

	public void run() {
		T2 t2;
		t2 = new T2();

		t1.qm1();
		try {
			t2.start();
			t1.qm2();
			t2.join();
		} catch (Exception ex) { }
	}
	public void qm1(){}
	public void qm2(){}

}

class T2 extends Thread {

	public void run() {
		T2 t2;
		t2 = this;

		t2.qm();
	}

	public void qm() {}
}

class O {
	public void qm1() { }
	public void qm2() { }
}
