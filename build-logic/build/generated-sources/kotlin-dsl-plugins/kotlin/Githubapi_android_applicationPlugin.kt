/**
 * Precompiled [githubapi.android.application.gradle.kts][Githubapi_android_application_gradle] script plugin.
 *
 * @see Githubapi_android_application_gradle
 */
public
class Githubapi_android_applicationPlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("Githubapi_android_application_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java, org.gradle.api.Project::class.java)
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}
