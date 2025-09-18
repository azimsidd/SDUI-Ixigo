package com.thecodingshef.testixigo.sdui

val json = """
    {
      "status": {
        "code": 200,
        "message": "SUCCESS"
      },
      "data": {
        "bgColor": "#F8F8F8",
        "results": [
          {
            "layoutConfig": {
              "snippetType": "header_chip_grid_type_2",
              "layoutType": "grid",
              "sectionCount": 1,
              "gridConfig": {
                "columns": 2,
                "spacing": 12
              }
            },
            "data": {
              "header": {
                "text": "Cheapest Fares From",
                "color": "#000000",
                "font": {
                  "size": 20,
                  "weight": "bold"
                }
              },
              "items": [
                {
                  "bgColor": "#FFFFFF",
                  "chip": {
                    "text": "New Delhi",
                    "color": "#000000",
                    "bgColor": "#FFFFFF",
                    "borderColor": "#CCCCCC",
                    "icon": "dropdown",
                    "clickAction": {
                      "type": "navigate",
                      "destination": "city_selector"
                    }
                  },
                  "cards": [
                    {
                      "id": "bathinda",
                      "image": {
                        "url": "https://example.com/bathinda.jpg",
                        "contentDescription": "Bathinda Fort"
                      },
                      "title": {
                        "text": "Bathinda",
                        "color": "#000000",
                        "font": {
                          "size": 18,
                          "weight": "bold"
                        }
                      },
                      "subtitle": {
                        "text": "Thu, 25 Sep",
                        "color": "#666666",
                        "font": {
                          "size": 14,
                          "weight": "regular"
                        }
                      },
                      "price": {
                        "text": "₹1,680",
                        "color": "#000000",
                        "font": {
                          "size": 16,
                          "weight": "bold"
                        }
                      },
                      "bgColor": "#FFFFFF",
                      "cornerRadius": 12,
                      "clickAction": {
                        "type": "navigate",
                        "destination": "flight_details",
                        "params": {
                          "destination": "bathinda",
                          "price": "1680"
                        }
                      }
                    },
                    {
                      "id": "hissar",
                      "image": {
                        "url": "https://example.com/hissar.jpg",
                        "contentDescription": "Hissar Lake"
                      },
                      "title": {
                        "text": "Hissar",
                        "color": "#000000",
                        "font": {
                          "size": 18,
                          "weight": "bold"
                        }
                      },
                      "subtitle": {
                        "text": "Sun, 21 Sep",
                        "color": "#666666",
                        "font": {
                          "size": 14,
                          "weight": "regular"
                        }
                      },
                      "price": {
                        "text": "₹1,949",
                        "color": "#000000",
                        "font": {
                          "size": 16,
                          "weight": "bold"
                        }
                      },
                      "bgColor": "#FFFFFF",
                      "cornerRadius": 12,
                      "clickAction": {
                        "type": "navigate",
                        "destination": "flight_details",
                        "params": {
                          "destination": "hissar",
                          "price": "1949"
                        }
                      }
                    },
                    {
                      "id": "gwalior",
                      "image": {
                        "url": "https://example.com/gwalior.jpg",
                        "contentDescription": "Gwalior Fort"
                      },
                      "title": {
                        "text": "Gwalior",
                        "color": "#000000",
                        "font": {
                          "size": 18,
                          "weight": "bold"
                        }
                      },
                      "subtitle": {
                        "text": "Thu, 02 Oct",
                        "color": "#666666",
                        "font": {
                          "size": 14,
                          "weight": "regular"
                        }
                      },
                      "price": {
                        "text": "₹2,083",
                        "color": "#000000",
                        "font": {
                          "size": 16,
                          "weight": "bold"
                        }
                      },
                      "bgColor": "#FFFFFF",
                      "cornerRadius": 12,
                      "clickAction": {
                        "type": "navigate",
                        "destination": "flight_details",
                        "params": {
                          "destination": "gwalior",
                          "price": "2083"
                        }
                      }
                    },
                    {
                      "id": "chandigarh",
                      "image": {
                        "url": "https://example.com/chandigarh.jpg",
                        "contentDescription": "Chandigarh Beach"
                      },
                      "title": {
                        "text": "Chandigarh",
                        "color": "#000000",
                        "font": {
                          "size": 18,
                          "weight": "bold"
                        }
                      },
                      "subtitle": {
                        "text": "Mon, 22 Sep",
                        "color": "#666666",
                        "font": {
                          "size": 14,
                          "weight": "regular"
                        }
                      },
                      "price": {
                        "text": "₹2,159",
                        "color": "#000000",
                        "font": {
                          "size": 16,
                          "weight": "bold"
                        }
                      },
                      "bgColor": "#FFFFFF",
                      "cornerRadius": 12,
                      "clickAction": {
                        "type": "navigate",
                        "destination": "flight_details",
                        "params": {
                          "destination": "chandigarh",
                          "price": "2159"
                        }
                      }
                    }
                  ],
                  "padding": {
                    "top": 16,
                    "bottom": 16,
                    "start": 16,
                    "end": 16
                  }
                }
              ]
            }
          },
          {
            "layoutConfig": {
              "snippetType": "image_title_subtitle_type_1",
              "layoutType": "grid",
              "sectionCount": 1,
              "gridConfig": {
                "columns": 1,
                "spacing": 12
              }
            },
            "data": {
              "items": [
                {
                  "bgColor": "#FFFFFF",
                  "title": {
                    "text": "Bathinda",
                    "color": "#000000",
                    "font": {
                      "size": 18,
                      "weight": "bold"
                    }
                  },
                  "subtitle": {
                    "text": "Thu, 25 Sep",
                    "color": "#666666",
                    "font": {
                      "size": 14,
                      "weight": "regular"
                    }
                  },
                  "padding": {
                    "top": 16,
                    "bottom": 16,
                    "start": 16,
                    "end": 16
                  }
                },
                {
                  "bgColor": "#FFFFFF",
                  "title": {
                    "text": "Bathinda",
                    "color": "#000000",
                    "font": {
                      "size": 18,
                      "weight": "bold"
                    }
                  },
                  "subtitle": {
                    "text": "Thu, 25 Sep",
                    "color": "#666666",
                    "font": {
                      "size": 14,
                      "weight": "regular"
                    }
                  },
                  "padding": {
                    "top": 16,
                    "bottom": 16,
                    "start": 16,
                    "end": 16
                  }
                }
              ]
            }
          }
        ]
      }
    }

""".trimIndent()