from selenium import webdriver
from selenium.webdriver.common.by import By
import time
#startar navegador
driver = webdriver.Chrome()
time.sleep(1)
driver.maximize_window()
time.sleep(1)
driver.get('https:www.google.com.br/')
time.sleep(1)

search_box = driver.find_element("name", "q")

search_box.send_keys('ComputaoUlbraTorres')

search_box.submit()