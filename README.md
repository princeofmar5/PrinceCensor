PCensor V1.0.1

This plugin censors all forms of words listed in the config.

Commands:
  /pcensor add [word]
    - This adds the string [word] to the list of censored words
  /pcensor remove [word]
    - This removes the string [word] from the list of censored words

Permissions:
  pcensor.*
    - Gives user permission to use every command
  pcensor.add
    - Gives user permission to use /pc add
  pcensor.remove
    - Gives user permission to use /pc remove
	
Version History:
V1.0 Initial release
  - Includes a config, manually add and remove words, permissions
V1.0.1 Bugfix
  - Fixed bug where you couldn't use caps in the config for words