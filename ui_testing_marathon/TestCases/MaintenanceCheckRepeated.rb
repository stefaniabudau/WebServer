#{{{ Marathon
require_fixture 'default'
#}}} Marathon

severity("normal")

def test

    with_window("WebServer") {
        click("start_Button")
        select("checkMaintenance", "checked")
        select("checkMaintenance", "unchecked")
        select("checkMaintenance", "checked")
        select("checkMaintenance", "unchecked")
        select("checkMaintenance", "checked")
        select("checkMaintenance", "unchecked")
        select("checkMaintenance", "checked")
        select("checkMaintenance", "unchecked")
        select("checkMaintenance", "checked")
        select("checkMaintenance", "unchecked")
        select("checkMaintenance", "checked")
        select("checkMaintenance", "unchecked")
        select("checkMaintenance", "checked")
        select("checkMaintenance", "unchecked")
        select("checkMaintenance", "checked")
        select("checkMaintenance", "unchecked")
        select("checkMaintenance", "checked")
        select("checkMaintenance", "unchecked")
        select("checkMaintenance", "checked")
        select("checkMaintenance", "unchecked")
        select("checkMaintenance", "checked")
        select("checkMaintenance", "unchecked")
        select("checkMaintenance", "checked")
        select("checkMaintenance", "unchecked")
        select("checkMaintenance", "checked")
        select("checkMaintenance", "unchecked")
        click("start_Button_2")
    }

end
