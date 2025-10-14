# 🧩 Selenium Web Automation Assignment

## 📘 Objective
This project automates an **end-to-end purchase flow** on a demo e-commerce website (e.g., [SauceDemo](https://www.saucedemo.com/)) using **Selenium WebDriver**, **Java**, and **TestNG** following the **Page Object Model (POM)** with **Page Factory** pattern.

---

## 🧠 Task Requirements

### Scenario
Automate the following steps:
1. Open a free demo website (e.g., SauceDemo ("https://www.saucedemo.com/v1/")).
2. Login using credentials stored in an **external file** (Excel or CSV).
3. Add the **first two products** to the cart.
4. Navigate to the cart and verify both products are listed.
5. Proceed to checkout and complete the purchase flow.
6. Assert that the final confirmation message equals:
   > “Thank you for your order!”
7. Capture a **screenshot** automatically when any assertion fails.

---

## 🏗️ Project Structure

WebAutomationTest/
│
├── src/main/java/com/seersolutions/pages/ # Page classes (LoginPage, InventoryPage, CartPage, CheckOutPage, ConfirmationPage.)
├── src/test/java/com/seersolutions/tests/ # Test classes (PurchaseScenarioTest)
├── src/main/java/com/seersolutions/utility/ # Utilities (ExcelUtils, TestListener, DataProvider)
├── testng.xml # Test Suite configuration
├── pom.xml # Maven dependencies and plugins
└── README.md # Project documentation



---

## ⚙️ Tools & Technologies

| Tool | Purpose |
|------|----------|
| **Java 11** | Programming language |
| **Selenium WebDriver** | Browser automation |
| **TestNG** | Test execution and reporting |
| **Apache POI** | Read data from Excel file |
| **Maven** | Dependency management |
| **Page Factory (POM)** | Maintainable and reusable framework |
| **Extent Reports / TestNG Listeners** | Screenshot capture on failure |

---

## 🧩 Key Features
- Implements **Page Object Model (POM)** with Page Factory.
- Data-driven testing using **Excel file**.
- **Assertions** for validation.
- Automatic **screenshot capture** on failure using TestNG listeners.
- Clear **test reports** for review.

---

## 📂 Test Data
| username | password |
|-----------|-----------|
| standard_user | secret_sauce |

Excel file: `testdata/credentials.xlsx`

---

## 🚀 How to Run the Tests

### 🧰 Prerequisites
- Install **Java JDK 11**
- Install **Maven 3.9**
- Install **Google Chrome**

### 🧭 Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/Prasanthpsg/WebAutomationTest.git

**Execute test via Maven:**
mvn clean test -DsuiteXmlFile=testng.xml

**Alternatively, run from IntelliJ:**

Right-click testng.xml

Select Run 'testng.xml'

**View test results:**

TestNG report: test-output/index.html

Screenshots (if failure): screenshots/

**Screenshot on Failure**

A TestNG Listener (TestListener.java) captures screenshots automatically.

**Design Highlights**

Reusable utility methods for Excel, driver, and screenshots.

Centralized test configuration in BaseTest.

Clear separation between test logic and UI interactions.

 **Expected Output**

Browser launches and logs in successfully.

Two products are added to the cart.

Checkout flow completes.

Message displayed:
"Thank you for your order"

Screenshot saved if any step fails.

<img width="975" height="428" alt="image" src="https://github.com/user-attachments/assets/93f200b6-6dc1-4bce-8071-5c1d0b5a67db" />

**Failure Scenario:**

Upon test failure, the ITestListener interface’s onTestFailure() method successfully captured a screenshot and saved it in the designated screenshots folder.

<img width="458" height="230" alt="image" src="https://github.com/user-attachments/assets/97ccc15d-13c2-49d4-b807-969fcf9f3937" />

**Execution video and step by step documentation:**

https://github.com/Prasanthpsg/WebAutomationTest/blob/main/Web%20Automation%20Report.docx

https://github.com/Prasanthpsg/WebAutomationTest/blob/main/Webautomationexecution_REC.mp4
