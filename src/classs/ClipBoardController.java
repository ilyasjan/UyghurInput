package classs;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class ClipBoardController {
	private Clipboard clipboard;

	public ClipBoardController() {
		clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	}

	public void SetClipText(String text) {
		StringSelection contents = new StringSelection(text);
		clipboard.setContents(contents, contents);
	}

	public String getClipString() {
		String content = "";
		if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
			try {
				content = (String) clipboard.getData(DataFlavor.stringFlavor);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				content = "I Can't got";
			}
		}
		return content;
	}
}
