package org.lds.drps.ws;

public class TestStringBuilder {

	public static void main(String[] args) {

		String test = "CHIPS_CHDAUTO_INGEST_POLL_JOB";
		StringBuilder newName = new StringBuilder(test);

		// remove CHIPS_ from the name
		int chipsBegin = 0;
		int chipsEnd = newName.indexOf("HIPS_") + 5;
		newName.delete(chipsBegin, chipsEnd);

		// remove AUTO_INGEST_POLL_JOB from name
		int autoBegin = newName.indexOf("AUTO_INGEST_POLL_JOB");
		int autoEnd = newName.length();
		newName.delete(autoBegin, autoEnd);

		// this.readableName = newName.toString();
		System.out.println("String: " + newName.toString());
	}

}
