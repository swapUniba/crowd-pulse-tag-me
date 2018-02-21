crowd-pulse-tag-me
==================

TagMe Crowd Pulse message tagger.

------------------

The `tagme` plugin needs a `tagme.properties` file with a `tagme.key` property.
To get your API key read the [Introduction](http://tagme.di.unipi.it/tagme_help.html#intro) on the 
[official Web site](http://tagme.di.unipi.it/).


You can specify the configuration option "calculate" with one of the following values:
- all: tag all messages coming from the stream;
- new: tag the messages with no tags (property is null or array is empty);

Example of usage:

```json
{
  "process": {
    "name": "tagme-tester",
    "logs": "/opt/crowd-pulse/logs"
  },
  "nodes": {
    "fetch": {
      "plugin": "message-fetch",
      "config": {
        "db": "test-tagme"
      }
    },
    "tagme": {
      "plugin": "tagme",
      "config": {
        "minRho": "0.15",
        "calculate": "new"
      }
    },
    "persistance": {
      "plugin": "message-persist",
      "config": {
        "db": "test-tagme"
      }
    }
  },
  "edges": {
    "fetch": [
      "tagme"
    ],
    "tagme": [
      "persistance"
    ]
  }
}
```