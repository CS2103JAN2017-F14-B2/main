# A0139975J-reused
###### /java/seedu/task/model/ModelManager.java
``` java
    @Override
    public void updateFilteredTaskList(boolean value) {
        updateFilteredTaskList(new PredicateExpression(new DoneQualifier(value)));
    }

```
###### /java/seedu/task/model/ModelManager.java
``` java
    @Override
    public void updateFilteredTaskList(Date date) {
        updateFilteredTaskList(new PredicateExpression(new DateQualifier(date)));

    }

    private void updateFilteredTaskList(Expression expression) {
        filteredTasks.setPredicate(expression::satisfies);
    }

    //========== Inner classes/interfaces used for filtering =================================================

    interface Expression {
        boolean satisfies(ReadOnlyTask task);
        @Override
        String toString();
    }


    private class PredicateExpression implements Expression {

        private final Qualifier qualifier;

        PredicateExpression(Qualifier qualifier) {
            this.qualifier = qualifier;
        }

        @Override
        public boolean satisfies(ReadOnlyTask task) {
            return qualifier.run(task);
        }

        @Override
        public String toString() {
            return qualifier.toString();
        }
    }

    interface Qualifier {
        boolean run(ReadOnlyTask task);
        @Override
        String toString();
    }

```
###### /java/seedu/task/ui/TaskListPanel.java
``` java
        @Override
        protected void updateItem(ReadOnlyTask task, boolean empty) {
            super.updateItem(task, empty);

            if (empty || task == null) {
                setGraphic(null);
                setText(null);
            } else {
                TaskCard taskcard = null;
                switch (TaskListPanel.this.theme) {
                case Dark:
                    taskcard = new TaskCard(task, getIndex() + 1, TaskCard.FXML_Dark);
                    break;
                case Light:
                    taskcard = new TaskCard(task, getIndex() + 1, TaskCard.FXML_Light);
                    break;
                default:
                    taskcard = new TaskCard(task, getIndex() + 1);
                }
                setGraphic(taskcard.getRoot());
                cardlist[getIndex() + 1] = (taskcard);

            }
        }
    }

}
```
###### /resources/view/DefaultTheme.css
``` css
.background {
    -fx-background-color: derive(#1d1d1d, 20%);
}

.label {
    //-fx-font-size: 11pt;
    //-fx-font-family: "Segoe UI Semibold";
    //-fx-text-fill: #555555;
    -fx-opacity: 0.9;
}

.label-bright {
    -fx-font-size: 11pt;
    -fx-font-family: "Segoe UI Semibold";
    -fx-text-fill: white;
    -fx-opacity: 1;
}

.label-header {
    -fx-font-size: 32pt;
    -fx-font-family: "Segoe UI Light";
    -fx-text-fill: white;
    -fx-opacity: 1;
}

.text-field {
    -fx-font-size: 12pt;
    -fx-font-family: "Segoe UI Semibold";
}

.tab-pane {
    -fx-padding: 0 0 0 1;
}

.tab-pane .tab-header-area {
    -fx-padding: 0 0 0 0;
    -fx-min-height: 0;
    -fx-max-height: 0;
}

.table-view {
    -fx-base: #1d1d1d;
    -fx-control-inner-background: #1d1d1d;
    -fx-background-color: #1d1d1d;
    -fx-table-cell-border-color: transparent;
    -fx-table-header-border-color: transparent;
    -fx-padding: 5;
}

.table-view .column-header-background {
    -fx-background-color: transparent;
}

.table-view .column-header, .table-view .filler {
    -fx-size: 35;
    -fx-border-width: 0 0 1 0;
    -fx-background-color: transparent;
    -fx-border-color:
        transparent
        transparent
        derive(-fx-base, 80%)
        transparent;
    -fx-border-insets: 0 10 1 0;
}

.table-view .column-header .label {
    -fx-font-size: 20pt;
    -fx-font-family: "Segoe UI Light";
    -fx-text-fill: white;
    -fx-alignment: center-left;
    -fx-opacity: 1;
}

.table-view:focused .table-row-cell:filled:focused:selected {
    -fx-background-color: -fx-focus-color;
}

.split-pane:horizontal .split-pane-divider {
    -fx-border-color: transparent #1d1d1d transparent #1d1d1d;
    -fx-background-color: transparent, derive(#1d1d1d, 10%);
}

.split-pane {
    -fx-border-radius: 1;
    -fx-border-width: 1;
    -fx-background-color: derive(#1d1d1d, 20%);
}

.list-cell {
    -fx-label-padding: 0 0 0 0;
    -fx-graphic-text-gap : 0;
    -fx-padding: 0 0 0 0;
    -fx-background-color : derive(C7D0D4,85%);
}

.list-cell .label {
    //-fx-text-fill: #010504;
}

.cell_big_label {
   -fx-font-size: 20px;
   //-fx-text-fill: #010504;
}

.cell_small_label {
    -fx-font-size: 16px;
    -fx-text-fill: #010504;
    -fx-background-color : white;
}

.anchor-pane {
     -fx-background-color: derive(#1d1d1d, 20%);
}

.anchor-pane-with-border {
     -fx-background-color: derive(#1d1d1d, 20%);
     -fx-border-color: derive(#1d1d1d, 10%);
     -fx-border-top-width: 1px;
}

.status-bar {
    -fx-background-color: derive(#1d1d1d, 20%);
    -fx-text-fill: black;
}

.result-display {
    -fx-background-color: #ffffff;
}

.result-display .label {
    -fx-text-fill: black !important;
}

.status-bar .label {
    -fx-text-fill: white;
}

.status-bar-with-border {
    -fx-background-color: derive(#1d1d1d, 30%);
    -fx-border-color: derive(#1d1d1d, 25%);
    -fx-border-width: 1px;
}

.status-bar-with-border .label {
    -fx-text-fill: white;
}

.grid-pane {
    -fx-background-color: derive(#1d1d1d, 30%);
    -fx-border-color: derive(#1d1d1d, 30%);
    -fx-border-width: 1px;
}

.grid-pane .anchor-pane {
    -fx-background-color: derive(#1d1d1d, 30%);
}

.context-menu {
    -fx-background-color: derive(#1d1d1d, 50%);
}

.context-menu .label {
    -fx-text-fill: white;
}

.menu-bar {
    -fx-background-color: derive(#1d1d1d, 20%);
}

.menu-bar .label {
    -fx-font-size: 14pt;
    -fx-font-family: "Segoe UI Light";
    -fx-text-fill: white;
    -fx-opacity: 0.9;
}

.menu .left-container {
    -fx-background-color: black;
}

.list-view {
	-fx-background-color: white;
}

.V-box {
	-fx-background-color: white;
}

/*
 * Metro style Push Button
 * Author: Pedro Duque Vieira
 * http://pixelduke.wordpress.com/2012/10/23/jmetro-windows-8-controls-on-java/
 */
.button {
    -fx-padding: 5 22 5 22;
    -fx-border-color: #e2e2e2;
    -fx-border-width: 2;
    -fx-background-radius: 0;
    -fx-background-color: #1d1d1d;
    -fx-font-family: "Segoe UI", Helvetica, Arial, sans-serif;
    -fx-font-size: 11pt;
    -fx-text-fill: #d8d8d8;
    -fx-background-insets: 0 0 0 0, 0, 1, 2;
}

.button:hover {
    -fx-background-color: #3a3a3a;
}

.button:pressed, .button:default:hover:pressed {
  -fx-background-color: white;
  -fx-text-fill: #1d1d1d;
}

.button:focused {
    -fx-border-color: white, white;
    -fx-border-width: 1, 1;
    -fx-border-style: solid, segments(1, 1);
    -fx-border-radius: 0, 0;
    -fx-border-insets: 1 1 1 1, 0;
}

.button:disabled, .button:default:disabled {
    -fx-opacity: 0.4;
    -fx-background-color: #1d1d1d;
    -fx-text-fill: white;
}

.button:default {
    -fx-background-color: -fx-focus-color;
    -fx-text-fill: #ffffff;
}

.button:default:hover {
    -fx-background-color: derive(-fx-focus-color, 30%);
}

.dialog-pane {
    -fx-background-color: #1d1d1d;
}

.dialog-pane > *.button-bar > *.container {
    -fx-background-color: #1d1d1d;
}

.dialog-pane > *.label.content {
    -fx-font-size: 14px;
    -fx-font-weight: bold;
    -fx-text-fill: white;
}

.dialog-pane:header *.header-panel {
    -fx-background-color: derive(#1d1d1d, 25%);
}

.dialog-pane:header *.header-panel *.label {
    -fx-font-size: 18px;
    -fx-font-style: italic;
    -fx-fill: white;
    -fx-text-fill: white;
}

.scroll-bar .thumb {
    -fx-background-color: derive(#1d1d1d, 50%);
    -fx-background-insets: 3;
}

.scroll-bar .increment-button, .scroll-bar .decrement-button {
    -fx-background-color: transparent;
    -fx-padding: 0 0 0 0;
}

.scroll-bar .increment-arrow, .scroll-bar .decrement-arrow {
    -fx-shape: " ";
}

.scroll-bar:vertical .increment-arrow, .scroll-bar:vertical .decrement-arrow {
    -fx-padding: 1 8 1 8;
}

.scroll-bar:horizontal .increment-arrow, .scroll-bar:horizontal .decrement-arrow {
    -fx-padding: 8 1 8 1;
}

#cardPane {
    -fx-background-color: transparent;
    -fx-border-color: #d6d6d6;
    -fx-border-width: 1 1 1 1;
}

#commandTypeLabel {
    -fx-font-size: 11px;
    -fx-text-fill: #F70D1A;
}

#filterField, #taskListPanel, #taskWebpage {
    -fx-effect: innershadow(gaussian, black, 10, 0, 0, 0);
}

#tags {
    -fx-hgap: 7;
    -fx-vgap: 3;
}

#tags .label {
    -fx-text-fill: white;
    -fx-background-color: #383838;
    -fx-padding: 1 3 1 3;
    -fx-border-radius: 2;
    -fx-background-radius: 2;
    -fx-font-size: 16;
}
```
###### /resources/view/TaskListCardDefault.fxml
``` fxml
<?import java.net.URL?>
<?import javafx.geometry.Insets?>
<?import javafx.scene.control.Label?>
<?import javafx.scene.control.TitledPane?>
<?import javafx.scene.layout.ColumnConstraints?>
<?import javafx.scene.layout.FlowPane?>
<?import javafx.scene.layout.GridPane?>
<?import javafx.scene.layout.HBox?>
<?import javafx.scene.layout.RowConstraints?>
<?import javafx.scene.layout.VBox?>
<?import javafx.scene.text.Font?>

<HBox id="cardPane" fx:id="cardPane" xmlns="http://javafx.com/javafx/8.0.111" xmlns:fx="http://javafx.com/fxml/1">
    <children>
        <GridPane HBox.hgrow="ALWAYS">
            <columnConstraints>
                <ColumnConstraints hgrow="SOMETIMES" minWidth="10.0" prefWidth="150.0" />
            </columnConstraints>
            <children>
            <TitledPane fx:id="plane">
               <content>
                      <VBox alignment="CENTER_LEFT" minHeight="105.0" styleClass="V-box">
                          <stylesheets>
                              <URL value="@Extensions.css" />
                              <URL value="@DefaultTheme.css" />
                          </stylesheets>
                          <padding>
                              <Insets bottom="5" left="15" right="5" top="5" />
                          </padding>

                          <children>
                              <Label fx:id="startDate" styleClass="cell_small_label" text="\$startDate" />
                              <Label fx:id="endDate" styleClass="cell_small_label" text="\$endDate" />
                              <Label fx:id="loc" styleClass="cell_small_label" text="\$loc" />
                              <Label fx:id="remark" styleClass="cell_small_label" text="\$remark" />
                          </children>
                      </VBox>
               </content>
               <graphic>
                  <HBox>
                     <children>
                        <Label fx:id="name" pickOnBounds="false" text="\$title" wrapText="true" HBox.hgrow="ALWAYS">
                           <font>
                              <Font name="Verdana Bold" size="20.0" />
                           </font>
                        </Label>
                              <FlowPane fx:id="tags">
                           <HBox.margin>
                              <Insets left="10.0" />
                           </HBox.margin>
                        </FlowPane>
                     </children>
                  </HBox>
               </graphic>
            </TitledPane>
            </children>
         <rowConstraints>
            <RowConstraints />
         </rowConstraints>
        </GridPane>
    </children>
</HBox>
```