"""Temporary: print the real structure of practice.qabrains.com pages for locator work."""
import re, time
from selenium import webdriver
from selenium.webdriver.common.by import By

o = webdriver.ChromeOptions()
for a in ["--headless=new", "--window-size=1920,1080", "--no-sandbox", "--disable-dev-shm-usage"]:
    o.add_argument(a)
d = webdriver.Chrome(options=o)
d.implicitly_wait(5)
BASE = "https://practice.qabrains.com"

def strip(tag):
    return re.sub(r'\s(class|style)="[^"]*"', "", tag)[:230]

def dump(label, area=None):
    time.sleep(3)
    print("#" * 20, label, d.current_url, "|", d.title)
    root = d.find_element(By.CSS_SELECTOR, area) if area else d.find_element(By.TAG_NAME, "main") if d.find_elements(By.TAG_NAME, "main") else d.find_element(By.TAG_NAME, "body")
    s = root.get_attribute("outerHTML")
    for t in re.findall(r"<(?:a|button|input|select|form)\b[^>]*>", s)[:70]:
        print("EL", strip(t))
    txt = re.sub(r"\s+", " ", root.text)
    print("TEXT", txt[:1500])

try:
    d.get(BASE + "/registration"); dump("REGISTRATION")
    regform = d.find_elements(By.TAG_NAME, "form")
    if regform:
        print("FORM_HTML", re.sub(r'\s(class|style)="[^"]*"', "", regform[0].get_attribute("outerHTML"))[:3000])

    d.get(BASE + "/ecommerce"); dump("ECOM LOGIN")
    text = d.find_element(By.TAG_NAME, "body").text
    emails = re.findall(r"[\w.+-]+@[\w-]+\.[\w.]+", text)
    pwds = re.findall(r"[Pp]assword\s*[:\-]?\s*(\S+)", text)
    print("CREDS", emails[:5], pwds[:5])
    email = next((e for e in emails if "support" not in e), "test@qabrains.com")
    pwd = next((p for p in pwds if len(p) > 4), "Password123")
    d.find_element(By.CSS_SELECTOR, "input[type=email], input#email").send_keys(email)
    d.find_element(By.CSS_SELECTOR, "input[type=password]").send_keys(pwd)
    d.find_element(By.CSS_SELECTOR, "button[type=submit]").click()
    dump("ECOM AFTER LOGIN")
    btns = [b for b in d.find_elements(By.TAG_NAME, "button") if "cart" in b.text.lower()]
    print("ADD_BUTTONS", len(btns), [b.text for b in btns[:5]])
    cards = d.find_elements(By.XPATH, "//button[contains(translate(.,'CART','cart'),'cart')]/ancestor::div[3]")
    if cards:
        print("CARD_HTML", strip(cards[0].get_attribute("outerHTML"))[:2500])
    if btns:
        btns[0].click(); time.sleep(2); dump("AFTER ADD")
        links = [a for a in d.find_elements(By.TAG_NAME, "a") if "cart" in (a.get_attribute("href") or "").lower()]
        print("CART_LINKS", [a.get_attribute("href") for a in links])
        if links:
            d.get(links[0].get_attribute("href")); dump("CART PAGE")
            print("CART_HTML", re.sub(r'\s(class|style)="[^"]*"', "", d.find_element(By.TAG_NAME, "body").get_attribute("outerHTML"))[:4000])
finally:
    d.quit()
