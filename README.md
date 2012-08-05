PrinceCensor V1.1 WIP

This plugin censors all forms of words listed in the config.

Commands:
  /pcensor add [word]
    - This adds the string [word] to the list of censored words
  /pcensor remove [word]
    - This removes the string [word] from the list of censored words
  /pcreload
    - This reloads the config

Permissions:
  princecensor.*
    - Gives user permission to use every command
  princecensor.add
    - Gives user permission to use /pcensor add
  princecensor.remove
    - Gives user permission to use /pcensor remove
  princecensor.reload
    - Gives user permission to reload the config
	
Version History:
V1.0 Initial release
  - Includes a config, manually add and remove words, permissions
V1.0.1 Bugfix
  - Fixed bug where you couldn't use caps in the config for words
V1.1 WIP
  - Changed the method of checking and censoring words