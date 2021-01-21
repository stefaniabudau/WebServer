#{{{ Marathon
require_fixture 'default'
#}}} Marathon

severity("normal")

def test

    with_window("WebServer") {
        select("portTextField", "8134")
        click("start_Button")
        click("start_Button_2")
        select("portTextField", "8135")
        click("start_Button")
        click("start_Button_2")
        select("portTextField", "8136")
        click("start_Button")
        click("start_Button_2")
        select("portTextField", "8137")
        click("start_Button")
        click("start_Button_2")
    }

end
