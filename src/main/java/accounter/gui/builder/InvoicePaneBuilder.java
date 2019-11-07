package accounter.gui.builder;

import accounter.backend.entity.*;
import accounter.backend.service.InvoiceService;
import accounter.backend.singelton.id.Id;
import accounter.backend.utils.DataValidator;
import accounter.gui.entity.Page;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class InvoicePaneBuilder implements Builder {
    private Page page;
    private ObservableList<InvoiceRow> data = FXCollections.observableArrayList();
    private TextField prodNumber = new TextField();
    private TextField description = new TextField();
    private TextField quantity = new TextField();
    private TextField uPrice = new TextField();
    private TextField subTotal = new TextField();
    private TextField totalPrice = new TextField();

    private TextField invoiceDate = new TextField();
    private TextField invoiceNumber = new TextField();

    private TextField shipToGender = new TextField();
    private TextField shipToName = new TextField();
    private TextField shipToAddress = new TextField();
    private TextField shipToCountry = new TextField();
    private TextField shipToZipCode = new TextField();
    private TextField shipToEmail = new TextField();
    private TextField shipToPhone = new TextField();

    private TextField billToGender = new TextField();
    private TextField billToName = new TextField();
    private TextField billToAddress = new TextField();
    private TextField billToCountry = new TextField();
    private TextField billToZipCode = new TextField();
    private TextField billToEmail = new TextField();
    private TextField billToPhone = new TextField();

    private TextField shipNumber = new TextField();
    private TextField saleRef = new TextField();
    private TextField shipDate = new TextField();
    private TextField shipVia = new TextField();
    private TextField terms = new TextField();
    private TextField shipDue = new TextField();

    private TextField vat = new TextField();
    private TextArea notes = new TextArea();

    private boolean billToSameAsShipTo = true;
    private boolean saved = false;
    private double totalP;


    @Override
    public void build() {
        page = new Page();
        totalPrice.setDisable(true);
        subTotal.setDisable(true);
        vat.setText("0");
        subTotal.setText("0");
        totalPrice.setText("0");
        Pane pane = page.getPane();
        Paint backgroundPaint = Color.YELLOW;
        pane.setBackground(new Background(new BackgroundFill(backgroundPaint, CornerRadii.EMPTY, Insets.EMPTY)));
        //Header
        pane.getChildren().add(setHeader());
        //ship to , bill to
        pane.getChildren().add(setClient());
        //shipping info
        pane.getChildren().add(setShippingData());
        //rows editor
        pane.getChildren().add(setRowsEditor());
        //table view
        pane.getChildren().add(setTableView());
        //note field
        pane.getChildren().add(setNoteField());
        //results fields
        pane.getChildren().add(setResultField());
        //save button
        pane.getChildren().add(setSaveButton());


    }

    private Node setHeader() {
        VBox vBox = new VBox(10);
        vBox.setLayoutX(650);
        vBox.setLayoutY(10);

        //set date auto current date
        HBox dateHBox = new HBox(45);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Label dateLabel = new Label("Invoice date:");
        invoiceDate.setText(sdf.format(new Date()));
        dateHBox.getChildren().addAll(dateLabel, invoiceDate);

        //set invoice number auto
        HBox numberHBox = new HBox(25);
        Label numberLabel = new Label("Invoice number:");
        invoiceNumber.setText(String.valueOf(Id.getNewId()));
        invoiceNumber.setDisable(true);
        numberHBox.getChildren().addAll(numberLabel, invoiceNumber);

        vBox.getChildren().addAll(dateHBox, numberHBox);
        return vBox;
    }

    private Node setClient() {
        VBox result = new VBox(20);
        HBox hBox = new HBox(214);

        //Ship to client
        hBox.getChildren().add(setShipTo());

        //Bill to client
        AtomicReference<Node> billToVBox = new AtomicReference<>(new VBox());
        RadioButton rb = new RadioButton("Ship to not same as billing ");
        rb.setOnAction(e -> {
            if (billToSameAsShipTo) {
                billToVBox.set(setBillTo());
                hBox.getChildren().add(billToVBox.get());
                billToSameAsShipTo = false;
            } else {
                hBox.getChildren().remove(billToVBox.get());
                billToSameAsShipTo = true;
            }
        });

        result.setLayoutX(90);
        result.setLayoutY(50);
        result.getChildren().addAll(rb, hBox);
        return result;
    }

    private Node setShipTo() {
        VBox shipToVBox = new VBox(5);
        Label shipToLabel = new Label("Ship To:");

        //name ,gender
        HBox line1 = new HBox(40);
        ChoiceBox<String> cb = new ChoiceBox<>();
        cb.setItems(FXCollections.observableArrayList("Mr", "Ms"));
        cb.setValue("Mr");
        shipToGender.setText("Mr");
        cb.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> shipToGender.setText(newValue));

        Label nameLabel = new Label("Name:");
        line1.getChildren().addAll(nameLabel, shipToName, cb);

        //address
        HBox line2 = new HBox(25);
        Label addressLabel = new Label("Address:");
        line2.getChildren().addAll(addressLabel, shipToAddress);

        //county
        HBox line3 = new HBox(27);
        Label countryLabel = new Label("Country:");
        line3.getChildren().addAll(countryLabel, shipToCountry);

        //zipCode
        HBox line4 = new HBox(24);
        Label zipCodeLabel = new Label("ZipCode:");
        line4.getChildren().addAll(zipCodeLabel, shipToZipCode);

        //Email
        HBox line5 = new HBox(43);
        Label emailLabel = new Label("Email:");
        line5.getChildren().addAll(emailLabel, shipToEmail);

        //Phone
        HBox line6 = new HBox(37);
        Label phoneLabel = new Label("Phone:");
        line6.getChildren().addAll(phoneLabel, shipToPhone);

        shipToVBox.getChildren().addAll(shipToLabel, line1, line2, line3, line4, line5, line6);
        return shipToVBox;
    }

    private Node setBillTo() {
        VBox billToVBox = new VBox(5);
        Label billToLabel = new Label("Bill To:");

        //name ,gender
        HBox line1 = new HBox(40);
        ChoiceBox<String> cb = new ChoiceBox<>();
        cb.setItems(FXCollections.observableArrayList("Mr", "Ms"));
        cb.setValue("Mr");
        billToGender.setText("Mr");
        cb.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> billToGender.setText(newValue));

        Label nameLabel = new Label("Name:");
        line1.getChildren().addAll(nameLabel, billToName, cb);

        //address
        HBox line2 = new HBox(25);
        Label addressLabel = new Label("Address:");
        line2.getChildren().addAll(addressLabel, billToAddress);

        //county
        HBox line3 = new HBox(27);
        Label countryLabel = new Label("Country:");
        line3.getChildren().addAll(countryLabel, billToCountry);

        //zipCode
        HBox line4 = new HBox(24);
        Label zipCodeLabel = new Label("ZipCode:");
        line4.getChildren().addAll(zipCodeLabel, billToZipCode);

        //Email
        HBox line5 = new HBox(43);
        Label emailLabel = new Label("Email:");
        line5.getChildren().addAll(emailLabel, billToEmail);

        //Phone
        HBox line6 = new HBox(37);

        Label phoneLabel = new Label("Phone:");
        line6.getChildren().addAll(phoneLabel, billToPhone);

        billToVBox.getChildren().addAll(billToLabel, line1, line2, line3, line4, line5, line6);
        return billToVBox;
    }

    private Node setShippingData() {
        HBox hBox = new HBox(10);
        hBox.setLayoutX(30);
        hBox.setLayoutY(300);

        //ship number
        VBox col1 = new VBox(10);
        Label shipNumberLabel = new Label("Ship. number");
        col1.getChildren().addAll(shipNumberLabel, shipNumber);

        //Sales Rep.
        VBox col2 = new VBox(10);
        Label saleRefLabel = new Label("Sales Rep.");
        col2.getChildren().addAll(saleRefLabel, saleRef);

        //Ship date
        VBox col3 = new VBox(10);
        Label shipDateLabel = new Label("Ship date");
        col3.getChildren().addAll(shipDateLabel, shipDate);

        //Ship via
        VBox col4 = new VBox(10);
        Label shipViaLabel = new Label("Ship via");
        col4.getChildren().addAll(shipViaLabel, shipVia);

        //Terms
        VBox col5 = new VBox(10);
        Label termsLabel = new Label("Terms");
        col5.getChildren().addAll(termsLabel, terms);

        //Due date
        VBox col6 = new VBox(10);
        Label shipDueLabel = new Label("Due date");
        col6.getChildren().addAll(shipDueLabel, shipDue);

        hBox.getChildren().addAll(col1, col2, col3, col4, col5, col6);
        return hBox;
    }

    private Node setRowsEditor() {
        HBox hBox = new HBox(10);
        hBox.setLayoutX(30);
        hBox.setLayoutY(360);

        Button btnNew = new Button("New Record");
        btnNew.setOnAction(t -> {
            InvoiceRow row = retrieveData();
            if (row != null) {
                data.add(row);
            }
        });

        //Product no.
        VBox col1 = new VBox(10);
        Label prodNumberLabel = new Label("Product no.");
        col1.getChildren().addAll(prodNumberLabel, prodNumber);

        //Sales Rep.
        VBox col2 = new VBox(10);
        Label descriptionLabel = new Label("Description.");
        col2.getChildren().addAll(descriptionLabel, description);

        //Quantity
        VBox col3 = new VBox(10);
        Label quantityLabel = new Label("Quantity");
        col3.getChildren().addAll(quantityLabel, quantity);

        //Unit price
        VBox col4 = new VBox(10);
        Label uPriceLabel = new Label("Unit price");
        col4.getChildren().addAll(uPriceLabel, uPrice);

        VBox col5 = new VBox(10);
        Label addLabel = new Label("Add");
        col5.getChildren().addAll(addLabel, btnNew);

        hBox.getChildren().addAll(col1, col2, col3, col4, col5);
        return hBox;
    }

    private Node setTableView() {

        TableView<InvoiceRow> tableView = new TableView<>();
        tableView.setLayoutX(30);
        tableView.setLayoutY(430);
        tableView.setEditable(true);
        tableView.setPrefHeight(200);
        tableView.setPrefWidth(700);
        TableColumn<InvoiceRow, String> colId = new TableColumn<>("Product no.");
        tableView.getColumns().add(colId);
        colId.setCellValueFactory(new PropertyValueFactory<>("productId"));
        colId.setPrefWidth(100);

        TableColumn<InvoiceRow, String> colDescription = new TableColumn<>("Description");
        tableView.getColumns().add(colDescription);
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colDescription.setPrefWidth(300);

        TableColumn<InvoiceRow, String> colQuantity = new TableColumn<>("Quantity");
        tableView.getColumns().add(colQuantity);
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colQuantity.setPrefWidth(100);

        TableColumn<InvoiceRow, String> colUnPrise = new TableColumn<>("Unit price.");
        tableView.getColumns().add(colUnPrise);
        colUnPrise.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colUnPrise.setPrefWidth(100);

        TableColumn<InvoiceRow, String> colTotal = new TableColumn<>("Total.");
        tableView.getColumns().add(colTotal);
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        colTotal.setPrefWidth(100);

        tableView.setItems(data);
        return tableView;

    }

    private InvoiceRow retrieveData() {
        String number = prodNumber.getText();
        String desc = description.getText();
        String quantityText = this.quantity.getText();
        String unPrice = this.uPrice.getText();
        if (!DataValidator.checkData(number, quantityText, unPrice)) {
            return null;
        }
        InvoiceRow invoiceRow = new InvoiceRow();
        double uP = Double.parseDouble(unPrice);
        int q = Integer.parseInt(quantityText);
        invoiceRow.setProductId(number);
        invoiceRow.setDescription(desc);
        invoiceRow.setQuantity(q);
        invoiceRow.setUnitPrice(uP);
        invoiceRow.setTotal(q * uP);
        totalP += q * uP;
        subTotal.setText(String.valueOf(totalP));
        totalPrice.setText(String.valueOf(totalP));
        prodNumber.clear();
        description.clear();
        quantity.clear();
        uPrice.clear();

        return invoiceRow;
    }

    private Node setNoteField() {
        VBox vBox = new VBox(3);
        vBox.setLayoutX(30);
        vBox.setLayoutY(635);

        Label label = new Label("Notes");
        notes.setPrefWidth(700);
        notes.setPrefHeight(135);
        vBox.getChildren().addAll(label, notes);

        return vBox;
    }

    private Node setResultField() {
        VBox vBox = new VBox(10);

        vBox.setLayoutY(430);
        vBox.setLayoutX(740);

        //Sub total
        VBox line1 = new VBox(5);
        Label subTotalLabel = new Label("Sub total");
        line1.getChildren().addAll(subTotalLabel, subTotal);

        //Vat
        VBox line2 = new VBox(5);
        Label vatLabel = new Label("Vat");
        vat.setOnKeyReleased(e -> {
            if (DataValidator.isNumeric(vat.getText())) {
                double v = Double.parseDouble(vat.getText());
                totalPrice.setText(String.valueOf(v + totalP));
            } else {
                vat.clear();
                totalPrice.clear();
            }
        });
        line2.getChildren().addAll(vatLabel, vat);

        //Total price
        VBox line3 = new VBox(5);
        Label totalPriceLabel = new Label("Total price");
        line3.getChildren().addAll(totalPriceLabel, totalPrice);

        vBox.getChildren().addAll(line1, line2, line3);

        return vBox;
    }

    private Node setSaveButton() {
        VBox vBox = new VBox(10);
        vBox.setLayoutX(740);
        vBox.setLayoutY(655);
        //save
        Button save = new Button("Save");
        Button print = new Button("Print");
        save.setOnAction(e -> saveData());
        print.setOnAction(e -> printDoc());
        vBox.getChildren().addAll(save, print);
        return vBox;
    }


    private void saveData() {

        if (data.isEmpty()){
            return;
        }

        Invoice invoice = new Invoice();
        InvoiceHeader header = new InvoiceHeader();
        header.setInvoiceDate(invoiceDate.getText());
        header.setInvoiceNumber(Long.parseLong(invoiceNumber.getText()));
        invoice.setInvoiceHeader(header);
        invoiceDate.clear();
        invoiceNumber.clear();

        Name shipToN = new Name();
        shipToN.setName(this.shipToName.getText());
        shipToN.setTitle(shipToGender.getText());
        shipToName.clear();
        shipToGender.clear();

        ShipTo shipTo = new ShipTo();
        shipTo.setName(shipToN);
        shipTo.setAddress(shipToAddress.getText());
        shipTo.setCountry(shipToCountry.getText());
        shipTo.setZipCode(shipToZipCode.getText());
        shipTo.setEmail(shipToEmail.getText());
        shipTo.setPhone(shipToPhone.getText());
        invoice.setShipTo(shipTo);

        if (!billToSameAsShipTo) {
            Name billToN = new Name();
            billToN.setName(this.billToName.getText());
            billToN.setTitle(billToGender.getText());

            billToName.clear();
            billToGender.clear();

            BillTo billTo = new BillTo();
            billTo.setName(billToN);
            billTo.setAddress(billToAddress.getText());
            billTo.setCountry(billToCountry.getText());
            billTo.setZipCode(billToZipCode.getText());
            billTo.setEmail(billToEmail.getText());
            billTo.setPhone(billToPhone.getText());
            invoice.setBillTo(billTo);
            billToAddress.clear();
            billToCountry.clear();
            billToZipCode.clear();
            billToEmail.clear();
            billToPhone.clear();

        } else {
            BillTo billTo = new BillTo();
            billTo.setName(shipToN);
            billTo.setAddress(shipToAddress.getText());
            billTo.setCountry(shipToCountry.getText());
            billTo.setZipCode(shipToZipCode.getText());
            billTo.setEmail(shipToEmail.getText());
            billTo.setPhone(shipToPhone.getText());
            invoice.setBillTo(billTo);
        }

        shipToAddress.clear();
        shipToCountry.clear();
        shipToZipCode.clear();
        shipToEmail.clear();
        shipToPhone.clear();

        ShippingData shippingData = new ShippingData();
        shippingData.setShipNumber(shipNumber.getText());
        shippingData.setSalesRep(saleRef.getText());
        shippingData.setDueDate(shipDate.getText());
        shippingData.setShipVia(shipVia.getText());
        shippingData.setTerms(terms.getText());
        shippingData.setDueDate(shipDue.getText());
        invoice.setShippingData(shippingData);

        shipNumber.clear();
        saleRef.clear();
        shipDate.clear();
        shipVia.clear();
        terms.clear();
        shipDue.clear();

        invoice.setNotes(notes.getText());
        List<InvoiceRow> rows = new ArrayList<>(data);
        invoice.setInvoiceRows(rows);
        invoice.setSubTotal(totalP);
        invoice.setVat(Double.parseDouble(vat.getText()));
        invoice.setTotal(Double.parseDouble(totalPrice.getText()));

        InvoiceService service = new InvoiceService();
        service.addInvoice(invoice);

        data.clear();
        notes.clear();
        totalP=0;
        vat.clear();
        totalPrice.clear();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        invoiceDate.setText(sdf.format(new Date()));
        Id.setPermit(true);
        invoiceNumber.setText(String.valueOf(Id.getNewId()));

    }

    private void printDoc() {
        if (saved) {
            System.out.println("print");
        }
    }


    @Override
    public Page getPage() {
        return page;
    }
}
