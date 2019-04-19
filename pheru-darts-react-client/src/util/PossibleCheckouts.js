import {SINGLE_IN} from "../constants/checkinModes";
import {DOUBLE_OUT} from "../constants/checkoutModes";

const POSSIBLE_CHECKOUTS = {};
POSSIBLE_CHECKOUTS[SINGLE_IN.key] = {};
POSSIBLE_CHECKOUTS[SINGLE_IN.key][DOUBLE_OUT.key] = {};
POSSIBLE_CHECKOUTS[SINGLE_IN.key][DOUBLE_OUT.key][1] = {
    2: "D1",
    4: "D2",
    6: "D3",
    8: "D4",
    10: "D5",
    12: "D6",
    14: "D7",
    16: "D8",
    18: "D9",
    20: "D10",
    22: "D11",
    24: "D12",
    26: "D13",
    28: "D14",
    30: "D15",
    32: "D16",
    34: "D17",
    36: "D18",
    38: "D19",
    40: "D20",
    50: "D25"
};
POSSIBLE_CHECKOUTS[SINGLE_IN.key][DOUBLE_OUT.key][2] = {
    2: "D1",
    3: "1 | D1",
    4: "D2",
    5: "1 | D2",
    6: "D3",
    7: "3 | D2",
    8: "D4",
    9: "1 | D4",
    10: "D5",
    11: "3 | D4",
    12: "D6",
    13: "5 | D4",
    14: "D7",
    15: "7 | D4",
    16: "D8",
    17: "9 | D4",
    18: "D9",
    19: "3 | D8",
    20: "D10",
    21: "5 | D8",
    22: "D11",
    23: "7 | D8",
    24: "D12",
    25: "1 | D12",
    26: "D13",
    27: "3 | D12",
    28: "D14",
    29: "5 | D12",
    30: "D15",
    31: "7 | D12",
    32: "D16",
    33: "1 | D16",
    34: "D17",
    35: "3 | D16",
    36: "D18",
    37: "5 | D16",
    38: "D19",
    39: "7 | D16",
    40: "D20",
    41: "9 | D16",
    42: "10 | D16",
    43: "11 | D16",
    44: "12 | D16",
    45: "13 | D16",
    46: "10 | D18",
    47: "15 | D16",
    48: "8 | D20",
    49: "9 | D20",
    50: "10 | D20",
    51: "11 | D20",
    52: "12 | D20",
    53: "13 | D20",
    54: "14 | D20",
    55: "15 | D20",
    56: "16 | D20",
    57: "17 | D20",
    58: "18 | D20",
    59: "19 | D20",
    60: "20 | D20",
    61: "T11 | D14",
    62: "T12 | D13",
    63: "T13 | D12",
    64: "T14 | D11",
    65: "T15 | D10",
    66: "T16 | D9",
    67: "T17 | D8",
    68: "T18 | D7",
    69: "T19 | D6",
    70: "T20 | D5",
    71: "T13 | D16",
    72: "T16 | D12",
    73: "T19 | D8",
    74: "T14 | D16",
    75: "T17 | D12",
    76: "T20 | D8",
    77: "T19 | D10",
    78: "T18 | D12",
    79: "T19 | D11",
    80: "T20 | D10",
    81: "T15 | D18",
    82: "T14 | D20",
    83: "T17 | D16",
    84: "T20 | D12",
    85: "T15 | D20",
    86: "T18 | D16",
    87: "T17 | D18",
    88: "T20 | D14",
    89: "T19 | D16",
    90: "T18 | D18",
    91: "T17 | D20",
    92: "T20 | D16",
    93: "T19 | D18",
    94: "T18 | D20",
    95: "T19 | D19",
    96: "T20 | D18",
    97: "T19 | D20",
    98: "T20 | D19",
    100: "T20 | D20",
    101: "T17 | D25",
    104: "T18 | D25",
    107: "T19 | D25",
    110: "T20 | D25"
};
POSSIBLE_CHECKOUTS[SINGLE_IN.key][DOUBLE_OUT.key][3] = {
    2: "D1",
    3: "1 | D1",
    4: "D2",
    5: "1 | D2",
    6: "D3",
    7: "3 | D2",
    8: "D4",
    9: "1 | D4",
    10: "D5",
    11: "3 | D4",
    12: "D6",
    13: "5 | D4",
    14: "D7",
    15: "7 | D4",
    16: "D8",
    17: "9 | D4",
    18: "D9",
    19: "3 | D8",
    20: "D10",
    21: "5 | D8",
    22: "D11",
    23: "7 | D8",
    24: "D12",
    25: "1 | D12",
    26: "D13",
    27: "3 | D12",
    28: "D14",
    29: "5 | D12",
    30: "D15",
    31: "7 | D12",
    32: "D16",
    33: "1 | D16",
    34: "D17",
    35: "3 | D16",
    36: "D18",
    37: "5 | D16",
    38: "D19",
    39: "7 | D16",
    40: "D20",
    41: "9 | D16",
    42: "10 | D16",
    43: "11 | D16",
    44: "12 | D16",
    45: "13 | D16",
    46: "10 | D18",
    47: "15 | D16",
    48: "8 | D20",
    49: "9 | D20",
    50: "10 | D20",
    51: "11 | D20",
    52: "12 | D20",
    53: "13 | D20",
    54: "14 | D20",
    55: "15 | D20",
    56: "16 | D20",
    57: "17 | D20",
    58: "18 | D20",
    59: "19 | D20",
    60: "20 | D20",
    61: "25 | D18",
    62: "T10 | D16",
    63: "T13 | D12",
    64: "T16 | D8",
    65: "T11 | D16",
    66: "T10 | D18",
    67: "T17 | D8",
    68: "T20 | D4",
    69: "T19 | D6",
    70: "T18 | D8",
    71: "T13 | D16",
    72: "T12 | D18",
    73: "T19 | D8",
    74: "T14 | D16",
    75: "T17 | D12",
    76: "T20 | D8",
    77: "T19 | D10",
    78: "T18 | D12",
    79: "T19 | D11",
    80: "T20 | D10",
    81: "T15 | D18",
    82: "D25 | D16",
    83: "T17 | D16",
    84: "T20 | D12",
    85: "T15 | D20",
    86: "T18 | D16",
    87: "T17 | D18",
    88: "T20 | D14",
    89: "T19 | D16",
    90: "T20 | D15",
    91: "D25 | 9 | D16",
    92: "D25 | 10 | D16",
    93: "D25 | 11 | D16",
    94: "D25 | 12 | D16",
    95: "D25 | 13 | D16",
    96: "T20 | D18",
    97: "T19 | D20",
    98: "T20 | D19",
    99: "T19 | 10 | D16",
    100: "T20 | D20",
    101: "T20 | 9 | D16",
    102: "T20 | 10 | D16",
    103: "T19 | 10 | D18",
    104: "T19 | 15 | D16",
    105: "T20 | 13 | D16",
    106: "T20 | 14 | D16",
    107: "T19 | 10 | D20",
    108: "T18 | 14 | D20",
    109: "T20 | 9 | D20",
    110: "T20 | 10 | D20",
    111: "T20 | 11 | D20",
    112: "T20 | 12 | D20",
    113: "T19 | 16 | D20",
    114: "T18 | 20 | D20",
    115: "T20 | 15 | D20",
    116: "T20 | 16 | D20",
    117: "T20 | 17 | D20",
    118: "T20 | 18 | D20",
    119: "T19 | T12 | D13",
    120: "T20 | 20 | D20",
    121: "T20 | T11 | D14",
    122: "T18 | T18 | D7",
    123: "T19 | T16 | D9",
    124: "T20 | T14 | D11",
    125: "D25 | 25 | D25",
    126: "T19 | 19 | D25",
    127: "T20 | T17 | D8",
    128: "T18 | T18 | D10",
    129: "T19 | T16 | D12",
    130: "T20 | 20 | D25",
    131: "T20 | T13 | D16",
    132: "D25 | T14 | D20",
    133: "T20 | T19 | D8",
    134: "T20 | T14 | D16",
    135: "D25 | T15 | D20",
    136: "T20 | T20 | D8",
    137: "T20 | T19 | D10",
    138: "T20 | T18 | D12",
    139: "T20 | T19 | D11",
    140: "T20 | T20 | D10",
    141: "T20 | T15 | D18",
    142: "T20 | T14 | D20",
    143: "T20 | T17 | D16",
    144: "T20 | T20 | D12",
    145: "T20 | T15 | D20",
    146: "T20 | T18 | D16",
    147: "T20 | T17 | D18",
    148: "T20 | T16 | D20",
    149: "T20 | T19 | D16",
    150: "T20 | T18 | D18",
    151: "T20 | T17 | D20",
    152: "T20 | T20 | D16",
    153: "T20 | T19 | D18",
    154: "T20 | T18 | D20",
    155: "T20 | T19 | D19",
    156: "T20 | T20 | D18",
    157: "T20 | T19 | D20",
    158: "T20 | T20 | D19",
    160: "T20 | T20 | D20",
    161: "T20 | T17 | D25",
    164: "T20 | T18 | D25",
    167: "T20 | T19 | D25",
    170: "T20 | T20 | D25"
};

export default POSSIBLE_CHECKOUTS;