pipeline {
    agent any

    environment {
        GIT_REPO = 'https://github.com/kefeihuang/login-app-1.git'
        GIT_BRANCH = 'master'

		PROJECT_HOME = 'C:/Users/kefei/Desktop/Study2026/JenkinsTutorial_1/login-app-1'

		// Define your Android SDK path explicitly so Gradle knows where tools are
        ANDROID_HOME = 'C:/Users/kefei/AppData/Local/Android/Sdk'
        // Specify your target package and test runner configurations
        MAIN_PACKAGE = 'com.example.loginapp1'
        TEST_RUNNER  = 'androidx.test.runner.AndroidJUnitRunner'
    }

    stages {
        stage('Prepare') {
            steps {
                dir('%PROJECT_HOME%')
            }
        }
		
		stage('Checkout Code') {
            steps {
                // If this is a local sandbox project, navigate to your desktop directory
                // Otherwise, delete the 'dir' block if Jenkins is pulling directly from Git
                
                    echo 'Workspace ready. Checking project files...'
					git branch: "${GIT_BRANCH}",
                    url: "${GIT_REPO}"
                
            }
        }

        stage('Verify Environment') {
            steps {
                bat '''
                    java -version
                    gradle -v || true
                '''
            }
        }

        stage('Clean') {
            steps {
                
                    echo 'Cleaning old build artifacts...'
                    // Using native Windows bat command completely avoids PowerShell script parsing errors
                    bat 'gradlew.bat clean'
                
            }
        }

		stage('Check Device') {
			steps {
				powershell 'adb devices'
			}
		}

        stage('Install Apps') {
            steps {
                
                    echo 'Deploying Main APK and Test APK to target device...'
                    // This forces BOTH required APK files onto the active device
                    bat 'gradlew.bat installDebug installDebugAndroidTest'
                
            }
        }

        stage('Run Instrumentation Tests') {
            steps {
                
                    echo 'Launching Android Test Runner execution loop...'
                    
                    // 1. Verify the device can actually see the newly installed test runner
                    powershell 'adb shell pm list instrumentation'
                    //bat '"%ANDROID_HOME%/platform-tools/adb.exe" shell pm list instrumentation'
                    
					powershell 'adb logcat -c'
					
                    // 2. Execute the test runner using the correct package suffix format (.test)
                    // The "-w" flag forces Jenkins to wait until the tests fully complete before moving on
                    bat 'gradlew.bat connectedDebugAndroidTest --info'
					// powershell 'adb shell am instrument -w -e class com.example.loginapp1.ExampleInstrumentedTest com.example.loginapp1.test/androidx.test.runner.AndroidJUnitRunner'
                    // bat '"%ANDROID_HOME%/platform-tools/adb.exe" shell am instrument -w -e class ${MAIN_PACKAGE}.ExampleInstrumentedTest ${MAIN_PACKAGE}.test/${TEST_RUNNER}'
                
            }
        }
    }

    post {
        always {
            // bat './gradlew :app:createAggregatedTestReport'
			powershell 'adb logcat -d | findstr KEFEI'
			powershell 'adb uninstall com.example.loginapp1'
            powershell 'adb uninstall com.example.loginapp1.test'
            echo 'Pipeline finished processing. Archiving execution logs...'
        }
        success {
            echo 'Android Test Automation Suite Passed Successfully!'
        }
        failure {
            echo 'Android Build or Test Instrumentation Suite Failed. Check individual stage logs above.'
        }
    }
}

