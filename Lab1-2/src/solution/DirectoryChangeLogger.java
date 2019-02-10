package solution;

public class DirectoryChangeLogger implements IDirectoryListener {
	final String CREATE_EVENT = "ENTRY_CREATE";
	final String DELETE_EVENT = "ENTRY_DELETE";

	@Override
	public void directoryChanged(DirectoryEvent e) {
		if (e.getEventType().equals(CREATE_EVENT)) {
			System.out.println("Create File " + e.getFile().toString());		
		}else {
			System.out.println("Deleted File " + e.getFile().toString());
		}

	}

}
