package insa.proxy.file;

// Such a proxy is usually developed when you cannot modify or sub-class legacy code.
public class ProxyFile implements File {
	private final FileImpl file;

	public ProxyFile(final FileImpl proxiedFile) {
		super();
		file = proxiedFile;
	}

	@Override
	public void save() {
		if(canWrite()) {
			file.save();
		}
	}

	private boolean canWrite() {
		// Do something to checking whether the file can be written on the disk.
		return true;
	}
}
