package application.dataClass;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableCell;
import javafx.scene.image.ImageView;

public class ImgTCell<S, T> extends TableCell<S, T> {
	private final ImageView img;
	private ObservableValue<T> ov;

	public ImgTCell() {
		this.img = new ImageView();
		// 添加元素
		setGraphic(img);
	}

	@Override
	public void updateItem(T item, boolean empty) {
		System.out.println("empty：" + empty);
		super.updateItem(item, empty);
		if (empty) {
			// 如果此列为空默认不添加元素
			setText(null);
			setGraphic(null);
		} else {
			// 初始化为不选中
			// img.setSelected(false);
			setGraphic(img);
		}
	}
}
