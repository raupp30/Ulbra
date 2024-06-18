from selenium import webdriver
from selenium.webdriver.common.by import By

#startar navegador
driver = webdriver.Edge()
#acessar url do python
driver.get('https:www.python.org/')
#digitar o texto python
driver.find_element(By.CSS_SELECTOR, ('#id-search-field')).send_keys("Python")
#clicar no botao go
driver.find_element(By.CSS_SELECTOR, ('#submit')).click()
#encerrar o browser
driver.quit()