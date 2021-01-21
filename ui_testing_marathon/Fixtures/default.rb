=begin
Launcher uses the properties specified here to launch the application
=end

#{{{ Fixture Properties
fixture_properties = {
        'marathon.project.launcher.model' => "com.jaliansystems.marathonite.launchers.executablejar.FXExecutableJarLauncherModel",
        'marathon.aut.executable.launch' => "%marathon.project.dir%/../webserver.jar",
        'marathon.application.arguments' => "",
        'marathon.application.working.dir' => "C:\\Users\\Stefii\\Desktop\\Year_4\\SVV\\SVV-Project\\WebServer",
        'marathon.application.vm.arguments' => "",
        'marathon.application.start.window' => "",
        'marathon.application.java.home' => "",
        'marathon.fixture.reuse' => ""
    }
#}}} Fixture Properties

=begin
Default Fixture
=end

class Fixture

=begin
    Marathon executes this method at the end of test script.
=end

    def teardown
        
    end

=begin
    Marathon executes this method before the test script.
=end

    def setup
    end

=begin
    Marathon executes this method after the first window of the application is displayed.
    You can add any Marathon script elements here.
=end

    def test_setup
        
    end

end

$fixture = Fixture.new

=begin
Any code you add below this comment is executed before the application is started.
You can use any ruby script here and not selenium and marathon script elements.
=end

