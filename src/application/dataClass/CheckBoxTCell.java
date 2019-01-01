package application.dataClass;

import com.jfoenix.controls.JFXCheckBox;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableCell;

public class CheckBoxTCell<S, T> extends TableCell<S, T> {
	private final JFXCheckBox chebox;
	private ObservableValue<T> ov;

	public CheckBoxTCell() {
		this.chebox = new JFXCheckBox();
		// 添加元素
		setGraphic(chebox);
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
			chebox.setSelected(false);
			setGraphic(chebox);
		}
	}
}
