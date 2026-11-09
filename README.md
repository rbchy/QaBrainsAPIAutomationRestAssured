<div align="center">

# 🔌 QaBrains API Automation — Rest Assured

### Hybrid BDD suite: REST API tests with Rest Assured + UI tests with Selenium, written in Cucumber

[![Typing SVG](https://readme-typing-svg.demolab.com/?font=Fira+Code&size=18&pause=1500&color=FFC107&center=true&vCenter=true&width=900&repeat=true&lines=Java+%C2%B7+Rest+Assured+%C2%B7+Cucumber+%C2%B7+Selenium+%C2%B7+TestNG;API%3A+GET+%C2%B7+POST+%C2%B7+PUT+%C2%B7+DELETE+%C2%B7+negative+checks;UI%3A+login%2C+registration%2C+cart%2C+forgot+password)](https://git.io/typing-svg)

<!-- ============ STATUS BAR ============ -->
![Status](https://img.shields.io/badge/Status-In%20Progress-f59e0b?style=for-the-badge&logo=checkmarx&logoColor=white)
![Scenarios](https://img.shields.io/badge/Scenarios-21%20(6%20API%20%C2%B7%2015%20UI)-155e75?style=for-the-badge)
![API](https://img.shields.io/badge/API-JSONPlaceholder-1e3a8a?style=for-the-badge&logo=json&logoColor=white)
![UI](https://img.shields.io/badge/UI-practice.qabrains.com-0d9488?style=for-the-badge&logo=googlechrome&logoColor=white)

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Rest Assured](https://img.shields.io/badge/Rest%20Assured-43B02A?style=for-the-badge&logo=java&logoColor=white)
![Cucumber](https://img.shields.io/badge/Cucumber-23D96C?style=for-the-badge&logo=cucumber&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-43B02A?style=for-the-badge&logo=selenium&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-FF7F00?style=for-the-badge)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)

![Last Commit](https://img.shields.io/github/last-commit/rbchy/QaBrainsAPIAutomationRestAssured?style=flat-square&color=0d9488&label=Last%20commit)
![Repo Size](https://img.shields.io/github/repo-size/rbchy/QaBrainsAPIAutomationRestAssured?style=flat-square&color=155e75&label=Repo%20size)
![Top Language](https://img.shields.io/github/languages/top/rbchy/QaBrainsAPIAutomationRestAssured?style=flat-square&color=f59e0b)

</div>

---

## 📌 At a Glance

<table>
<tr>
<td width="50%" valign="top">

**🙋 What this is**

One Cucumber project that tests a system from **two sides**: the **REST API** layer (create, read, update, delete and an invalid-endpoint check, sent with **Rest Assured**) and the **web UI** (login, registration, cart, forgot password and navigation, driven with **Selenium**). Every scenario is plain-English **Gherkin** and is tagged so a smoke run, a regression run or a single module can be picked from the command line.

> *An API that answers 200 and a page that shows nothing is still a defect — test both.*

</td>
<td width="50%" valign="top">

**📍 Quick facts**

| | |
|---|---|
| 🔌 **API target** | [jsonplaceholder.typicode.com](https://jsonplaceholder.typicode.com) |
| 🌐 **UI target** | [practice.qabrains.com](https://practice.qabrains.com/) |
| 🧪 **Scenarios** | 21 in 13 feature files |
| 🏷️ **Suites** | `@smoke` · `@regression` · `@api` |
| ⚙️ **Config** | `src/test/resources/config.properties` |

</td>
</tr>
</table>

---

## 🧭 How It Fits Together

```mermaid
flowchart LR
  F["Feature files<br/>(Gherkin)"] --> T{"Tag"}
  T -->|"@api"| RA["Rest Assured<br/>given / when / then"]
  T -->|"UI tags"| SE["Selenium WebDriver<br/>+ WebDriverManager"]
  RA --> JP["JSONPlaceholder<br/>REST API"]
  SE --> CH["Chrome<br/>(incognito, no password popups)"]
  CH --> QB["practice.qabrains.com"]
  C["config.properties<br/>url · base_url · timeout · test user"] -.-> RA
  C -.-> SE
```

---

## 🔌 API Coverage

| # | Feature file | Scenario | Method | Tags |
|---|---|---|---|---|
| 1 | `APIgetUser.feature` | Get user details | `GET` | `@smoke @regression @api @get` |
| 2 | `APIcreateUser.feature` | Create a user | `POST` | `@smoke @regression @api @create` |
| 3 | `APIupdateUser.feature` | Update a user | `PUT` | `@smoke @regression @api @update` |
| 4 | `APIdeleteUser.feature` | Delete a user | `DELETE` | `@smoke @regression @api @delete` |
| 5 | `APInegativeTest.feature` | Call an invalid endpoint → error expected | `GET` | `@smoke @regression @api @negative` |
| 6 | `APITest.feature` | Update user (combined API feature) | `PUT` | `@smoke @regression` |

Every API scenario follows the same shape:

```gherkin
Given API base URI is set          # base_url from config.properties
When I create a user               # Rest Assured request
Then API response should be valid  # status code + response body checks
```

---

## 🌐 UI Coverage

<details open>
<summary><strong>🔐 Login · Logout · Registration · Forgot Password</strong></summary>

<br>

| Feature | Scenarios | Positive / Negative |
|---|---|---|
| `Login.feature` | Valid credentials · invalid credentials | ✅ / ❌ |
| `Logout.feature` | Logged-in user logs out | ✅ |
| `Registration.feature` | Register with a valid email · reject an email without `@` | ✅ / ❌ |
| `ForgotPassword.feature` | Reset for a registered email · reject a malformed email | ✅ / ❌ |

</details>

<details>
<summary><strong>🛒 Cart</strong></summary>

<br>

| Feature | Scenarios |
|---|---|
| `CartCheckout.feature` | Add a product to the cart · remove it and confirm the cart is empty |

</details>

<details>
<summary><strong>💨 Smoke & Regression packs</strong></summary>

<br>

| Feature | Scenarios |
|---|---|
| `SmokeTests.feature` | S-01 home page loads · S-02 Catalog / About / Blog navigation · S-03 Wish list and Refer a Friend |
| `RegressionTests.feature` | R-01 add multiple products · R-02 update quantity · R-03 search for an item that does not exist |

</details>

---

## 🛠️ Tech Stack

| Layer | Technology | Purpose |
|---|---|---|
| Language | Java | Test code |
| API testing | Rest Assured | Fluent `given / when / then` HTTP requests and assertions |
| UI testing | Selenium WebDriver | Drives Chrome |
| Driver management | WebDriverManager | Downloads the matching ChromeDriver automatically |
| BDD | Cucumber (Gherkin) | Readable scenarios shared by API and UI |
| Runner | TestNG | Executes Cucumber scenarios |
| Build | Maven | Dependencies and `mvn test` |
| Config | Java `Properties` | Environment values in one file |

---

## 📁 Project Structure

```
QaBrainsAPIAutomationRestAssured/
├── src/test/java/utils/
│   ├── BaseTest.java            ← loads config.properties, Chrome setup (incognito,
│   │                              password-manager popups off, waits), health check
│   ├── DriverFactory.java       ← ThreadLocal driver, ready for parallel runs
│   └── DriverHelper.java        ← simple local-driver helper
├── src/test/resources/
│   ├── config.properties        ← UI url, browser, timeout, test user, API base_url
│   ├── testdata.json            ← test data file
│   └── features/
│       ├── APIgetUser.feature        APIcreateUser.feature
│       ├── APIupdateUser.feature     APIdeleteUser.feature
│       ├── APInegativeTest.feature   APITest.feature
│       ├── Login.feature             Logout.feature
│       ├── Registration.feature      ForgotPassword.feature
│       ├── CartCheckout.feature
│       ├── SmokeTests.feature        RegressionTests.feature
└── README.md
```

> 🚧 **Repository status:** this repository currently holds the feature files, configuration and driver utilities. The Maven `pom.xml`, step definitions and Cucumber runners are being added next — see the roadmap.

---

## ⚙️ Configuration

`src/test/resources/config.properties`

```properties
# UI
url=https://practice.qabrains.com/
browser=chrome
timeout=10

# API
base_url=https://jsonplaceholder.typicode.com
```

The UI test user (`valid_email`, `valid_password`) is the public practice account published by QA Brains — no real personal data is used.

---

## ▶️ Running the Tests

*(once `pom.xml` and the runners are committed)*

```bash
git clone https://github.com/rbchy/QaBrainsAPIAutomationRestAssured.git
cd QaBrainsAPIAutomationRestAssured

# Everything
mvn clean test

# API only
mvn clean test -Dcucumber.filter.tags="@api"

# Smoke pack / regression pack
mvn clean test -Dcucumber.filter.tags="@smoke"
mvn clean test -Dcucumber.filter.tags="@regression"

# One module
mvn clean test -Dcucumber.filter.tags="@Login or @Registration"
```

---

## 🏷️ Tags

| Tag | Meaning |
|---|---|
| `@smoke` | Critical path — quick build check |
| `@regression` | Full suite |
| `@api` | All Rest Assured scenarios |
| `@get` `@create` `@update` `@delete` `@negative` | One API operation |
| `@Login` `@Logout` `@Registration` `@ForgotPassword` | One UI module |

---

## 📈 Roadmap

- [ ] Commit `pom.xml` (Rest Assured, Cucumber, TestNG, Selenium, WebDriverManager)
- [ ] Commit step definitions, hooks and Cucumber runners
- [ ] API assertions on status code, response time and JSON fields; JSON Schema validation
- [ ] Request / response POJOs instead of raw JSON
- [ ] Cucumber HTML + Allure reports
- [ ] GitHub Actions workflow running the API pack on every push
- [ ] Clean-up: merge `APITest.feature` into `APIupdateUser.feature`; align the expected text in the malformed-email Forgot Password scenario with the email it sends

---

## 🔗 Related Projects

| Project | Stack |
|---|---|
| ⭐ [RbcTcsWorld E-Commerce Suite](https://github.com/rbchy/RbcTcsWorld_ECommerceSuite) | Spring Boot · REST Assured · Selenium · Playwright · CI quality gates |
| 🔌 [API — Postman / Newman](https://github.com/rbchy/QaBrainsAPIAutomation_Postman) | Postman · Newman |
| 🔬 [QA Brains — Java + Playwright](https://github.com/rbchy/QaBrainsAutomationJavaPlaywright) | Java 17 · Playwright · Cucumber JVM · TestNG |
| 🏥 [OpenEMR Healthcare](https://github.com/rbchy/OpenEMR_Automation) | Java · Selenium · Cucumber · TestNG |

<sub>All projects: [github.com/rbchy](https://github.com/rbchy)</sub>

---

## 👤 Author

<div align="center">

**Ranajit Baran Chowdhury (RB Chowdhury)**
QA Automation Engineer / SDET · West Norriton, Pennsylvania, USA

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/rbchy/)
[![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/rbchy)
[![Website](https://img.shields.io/badge/Website-rbchy.github.io%2Frbchy-0d9488?style=for-the-badge&logo=githubpages&logoColor=white)](https://rbchy.github.io/rbchy/)
[![Portfolio](https://img.shields.io/badge/Portfolio-Website-blueviolet?style=for-the-badge&logo=wix&logoColor=white)](https://rbc6543.wixsite.com/rbc-portfolio)
[![Gmail](https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:chyranajit@gmail.com)

<sub>Provided for educational and professional QA automation purposes. JSONPlaceholder and QA Brains are public practice services.</sub>

⭐ *If this project helps you, a star on the repo is appreciated.*

</div>
