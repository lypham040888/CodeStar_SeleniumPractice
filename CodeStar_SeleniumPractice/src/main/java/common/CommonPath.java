package common;

public class CommonPath {

	/**
	 * get absolute path of file
	 * 
	 * @param relativeFilePath
	 * @return
	 */
	public String getAbsoluteFilePath(String relativeFilePath) {
		String curDir = System.getProperty("user.dir");
		String absolutePath = curDir + relativeFilePath;
		return absolutePath;
	}
	public String getUserDir() {
		String curDir = System.getProperty("user.dir");
		return curDir;
	}
}
