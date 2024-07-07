# Exler plugin loader
A simple Java plugin loader (i dont recommend using this, code your own)

# how it works in a nutshell
It creates a temporary file and uses fikles.copy to copy the contents of the stream from the url to the temporary file. the file acts as a plugin jar
the loader uses Bukkit.getPluginManager().loadPlugin(tempFile) to load the plugin from the temporary file into memory

# why i open sourced this
idk i just wanted to open source it on skibidi

# TOS
- If you wanna sell a forked version of this base you must gain permission from either "vifez" or "DevMatt_"
- You MUST provide credits to "Kira Development" for usage of this base.
