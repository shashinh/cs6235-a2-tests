class P {
	public static void main(String [] args){
			T1 t1;
			O o;
			boolean b;
		try {

			o = new O();
			t1 = new T1();


			b = o.getBool();;
			if(b) {
				t1.start();
			} else { }

			if(b) {
				t1.join();
			} else { } 

			o.qm();


		} catch (Exception ex) {
		}
	}
}

class T1 extends Thread {

	public void run() {
		T1 t1;
		t1 = this;
		t1.qm();
	}

	public void qm() {}

}


class L {
}

class O {
	public void qm() {}
	public boolean getBool() {
		boolean ret;
		ret = true;
		return ret;
	}
}
