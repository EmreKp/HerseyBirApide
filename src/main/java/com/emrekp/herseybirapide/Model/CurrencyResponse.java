
package com.emrekp.herseybirapide.Model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Currency" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Unit" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *                   &lt;element name="Isim" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="CurrencyName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="ForexBuying" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                   &lt;element name="ForexSelling" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="BanknoteBuying" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="BanknoteSelling" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="CrossRateUSD" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="CrossRateOther" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="CrossOrder" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                 &lt;attribute name="Kod" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="CurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="Tarih" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Date" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Bulten_No" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "currency"
})
@XmlRootElement(name = "Tarih_Date")
public class CurrencyResponse {

    @XmlElement(name = "Currency")
    protected List<Currency> currency;
    @XmlAttribute(name = "Tarih")
    protected String tarih;
    @XmlAttribute(name = "Date")
    protected String date;
    @XmlAttribute(name = "Bulten_No")
    protected String bultenNo;

    /**
     * Gets the value of the currency property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the currency property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCurrency().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Currency }
     * 
     * 
     */
    public List<Currency> getCurrency() {
        if (currency == null) {
            currency = new ArrayList<Currency>();
        }
        return this.currency;
    }

    /**
     * Gets the value of the tarih property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTarih() {
        return tarih;
    }

    /**
     * Sets the value of the tarih property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTarih(String value) {
        this.tarih = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDate(String value) {
        this.date = value;
    }

    /**
     * Gets the value of the bultenNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBultenNo() {
        return bultenNo;
    }

    /**
     * Sets the value of the bultenNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBultenNo(String value) {
        this.bultenNo = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Unit" type="{http://www.w3.org/2001/XMLSchema}byte"/>
     *         &lt;element name="Isim" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="CurrencyName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="ForexBuying" type="{http://www.w3.org/2001/XMLSchema}float"/>
     *         &lt;element name="ForexSelling" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="BanknoteBuying" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="BanknoteSelling" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="CrossRateUSD" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="CrossRateOther" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *       &lt;attribute name="CrossOrder" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *       &lt;attribute name="Kod" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="CurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "unit",
        "isim",
        "currencyName",
        "forexBuying",
        "forexSelling",
        "banknoteBuying",
        "banknoteSelling",
        "crossRateUSD",
        "crossRateOther"
    })
    public static class Currency {

        @XmlElement(name = "Unit")
        protected byte unit;
        @XmlElement(name = "Isim", required = true)
        protected String isim;
        @XmlElement(name = "CurrencyName", required = true)
        protected String currencyName;
        @XmlElement(name = "ForexBuying")
        protected float forexBuying;
        @XmlElement(name = "ForexSelling", required = true)
        protected String forexSelling;
        @XmlElement(name = "BanknoteBuying", required = true)
        protected String banknoteBuying;
        @XmlElement(name = "BanknoteSelling", required = true)
        protected String banknoteSelling;
        @XmlElement(name = "CrossRateUSD", required = true)
        protected String crossRateUSD;
        @XmlElement(name = "CrossRateOther", required = true)
        protected String crossRateOther;
        @XmlAttribute(name = "CrossOrder")
        protected Byte crossOrder;
        @XmlAttribute(name = "Kod")
        protected String kod;
        @XmlAttribute(name = "CurrencyCode")
        protected String currencyCode;

        /**
         * Gets the value of the unit property.
         * 
         */
        public byte getUnit() {
            return unit;
        }

        /**
         * Sets the value of the unit property.
         * 
         */
        public void setUnit(byte value) {
            this.unit = value;
        }

        /**
         * Gets the value of the isim property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIsim() {
            return isim;
        }

        /**
         * Sets the value of the isim property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIsim(String value) {
            this.isim = value;
        }

        /**
         * Gets the value of the currencyName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCurrencyName() {
            return currencyName;
        }

        /**
         * Sets the value of the currencyName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCurrencyName(String value) {
            this.currencyName = value;
        }

        /**
         * Gets the value of the forexBuying property.
         * 
         */
        public float getForexBuying() {
            return forexBuying;
        }

        /**
         * Sets the value of the forexBuying property.
         * 
         */
        public void setForexBuying(float value) {
            this.forexBuying = value;
        }

        /**
         * Gets the value of the forexSelling property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getForexSelling() {
            return forexSelling;
        }

        /**
         * Sets the value of the forexSelling property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setForexSelling(String value) {
            this.forexSelling = value;
        }

        /**
         * Gets the value of the banknoteBuying property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBanknoteBuying() {
            return banknoteBuying;
        }

        /**
         * Sets the value of the banknoteBuying property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBanknoteBuying(String value) {
            this.banknoteBuying = value;
        }

        /**
         * Gets the value of the banknoteSelling property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBanknoteSelling() {
            return banknoteSelling;
        }

        /**
         * Sets the value of the banknoteSelling property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBanknoteSelling(String value) {
            this.banknoteSelling = value;
        }

        /**
         * Gets the value of the crossRateUSD property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCrossRateUSD() {
            return crossRateUSD;
        }

        /**
         * Sets the value of the crossRateUSD property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCrossRateUSD(String value) {
            this.crossRateUSD = value;
        }

        /**
         * Gets the value of the crossRateOther property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCrossRateOther() {
            return crossRateOther;
        }

        /**
         * Sets the value of the crossRateOther property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCrossRateOther(String value) {
            this.crossRateOther = value;
        }

        /**
         * Gets the value of the crossOrder property.
         * 
         * @return
         *     possible object is
         *     {@link Byte }
         *     
         */
        public Byte getCrossOrder() {
            return crossOrder;
        }

        /**
         * Sets the value of the crossOrder property.
         * 
         * @param value
         *     allowed object is
         *     {@link Byte }
         *     
         */
        public void setCrossOrder(Byte value) {
            this.crossOrder = value;
        }

        /**
         * Gets the value of the kod property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getKod() {
            return kod;
        }

        /**
         * Sets the value of the kod property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setKod(String value) {
            this.kod = value;
        }

        /**
         * Gets the value of the currencyCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCurrencyCode() {
            return currencyCode;
        }

        /**
         * Sets the value of the currencyCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCurrencyCode(String value) {
            this.currencyCode = value;
        }

    }

}
