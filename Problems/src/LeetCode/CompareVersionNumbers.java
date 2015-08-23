package LeetCode;

public class CompareVersionNumbers {

	public int compareVersion(String version1, String version2) {
		String[] levels1 = version1.split("\\.");
		String[] levels2 = version2.split("\\.");

		int length = Math.max(levels1.length, levels2.length);
		for (int i=0; i<length; i++) {
			Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
			Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
			int compare = v1.compareTo(v2);
			if (compare != 0) {
				return compare;
			}
		}

		return 0;
	}

	public static void main(String[] args) {

		String s1 = "00000";
		String s2 = "00.000";

		CompareVersionNumbers c = new CompareVersionNumbers();
		System.out.println(c.compareVersion(s1, s2));

	}

}
